import java.time.LocalDateTime

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42;

  // Int, Boolean, Char, Double, Float
  val aBoolean = false // type is optional

  val aString = "I love this Scala"
  val aComposedString = "I" + " " + "love" + " " + "this" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expression = structures that can be reduced to a value.
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 100) 56 else 999 // in others language: meaningOfLife > 100 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  val aCodeBlock = {
    val aLocalValue = 67

    aLocalValue + 3
  }

  println(aCodeBlock) // 70

  // define function
  def myFunction(x: Int, y: String): String = y + " " + x
  println(myFunction(10, "hi"))

  // good code style (pure function)
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n-1)
  }

  // don't write the Scala like this on production.
  def factorialDP(n: Int): Int = {
    val dp = Array.fill[Int](n+1)(1)
    for (i <- 2 to n) {
      dp(i) = dp(i-1) * i
    }
    dp(n)
  }
  println(factorialDP(5))

  // In Scala we don't use loops or iteration, we use RECURSION !

  // the Unit type = void in others language.
  // type of SIDE EFFECTS
  def log(level: String, message: String): Unit = println(s"[$level] - ${LocalDateTime.now()} - $message")

  log("INFO", "Running Scala basic")
  log("WARN", "Testing warning level log")
}
