object SemigroupBasic extends App {
  /*
  * Semigroup -> an abstract type that must satisfy 2 key properties:
  * #1: Binary operation -> a function (x: T, y: T): T
  * #2: Associativity -> the grouping of operations does not affect the result
  *                      [e.g., (1 + (2 + 3)) = ((1 + 2) + 3)].
  *
  * Note: Commutativity (e.g., x + y = y + x) is NOT required for Semigroup.
  *
  * Conclusion: Any type with these two properties qualifies as a Semigroup.
  */

  trait Semigroup[T] {
    def binaryOperation(a: T, b: T): T
  }

  object BinaryOperation {
    implicit val intOperation = new Semigroup[Int] {
      def binaryOperation(a: Int, b: Int): Int = a + b
    }
    implicit val strOperation = new Semigroup[String] {
      def binaryOperation(a: String, b: String): String = a + b
    }
  }
  def reduce[T](list: List[T])(implicit semigroup: Semigroup[T]): T =
    list.reduce(semigroup.binaryOperation)

  import BinaryOperation._
  val reducedListOfInt = reduce(List(1,2,3))
  println(reducedListOfInt)

  val reducedListOfString = reduce(List("B", "A", "N", "K"))
  println(reducedListOfString)
}
