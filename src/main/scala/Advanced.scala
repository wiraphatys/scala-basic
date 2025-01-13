import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  /*
   *  LAZY EVALUATION
   */
  // the val will not execute until first time you use it.
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }
  val valueWithSideEffect = { // Scala will execute this block immediately but not execute the lazyValueWithSideEffect above.
    println("I am not lazy!")
    34
  }

  val eagerValue = lazyValueWithSideEffect + 100  // lazyValueWithSideEffect will executed here !
  // lazy evaluation is useful in infinite collections.

  /*
   *  PSEUDO COLLECTIONS: Option, Try
   */
  // Option = "collection" which contains at most one element: Some(value) or None
  def methodWhichCanReturnNull(): String = "hello, Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  // Try = "collection" with either a value if the code went well, or an exception if the code threw one.
  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())
  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }
  //  EX: unreadable syntax
  //  try {
  //    methodWhichCanThrowException()
  //  } catch {
  //    case e: Exception => "defend against this evil exception"
  //  }

  /*
   * Evaluate something on another thread: Future
   * (asynchronous programming)
   */
  val aFuture = Future({  // everything in this block in running on another thread
    println("Loading . . .")
    Thread.sleep(1000)
    println("I have computed")
    67
  })

  Thread.sleep(2000)
  println("close . . .")

  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatmap and filter
  // Monads

  /*
   * Implicits basics
   */
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs)  // equivalent to aMethodWithImplicitArgs(47)
  // a compiler is trying to match implicit args with implicit value in codebase and auto parse to function.

  // #2: implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()

  val rich = new MyRichInteger(23)
  println("is 23 even ? ", rich.isEven())
}
