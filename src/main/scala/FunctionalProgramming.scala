object FunctionalProgramming extends App {
  // Scala is Object Oriented language

  class Person(name: String) {
    def apply(age: Int) = println(s"I have age $age years.")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM (built for Java)
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... , Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 args and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", "Scala") // I love Scala

  // syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x // can be shorter by: val doubler = (x: Int) => 2 * x
  doubler(4)  // 8

  /*
    # equivalent to the much longer:

    val doubler: Function[Int, Int] = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */

  val aList = List(1,2,3)
  // higher-order functions: take functions as args/return functions as results
  // .map(function)
  val aMappedList: List[Int] = aList.map(x => x + 1) // no need to declare type of x like this: (x: Int => x + 1)
  println(aMappedList)

  // .flatMap(function)
  val aFlatMappedList = aList.flatMap(x => List(x, -x))
  println(aFlatMappedList)

  val alternativeFlatMappedList = aList.flatMap(x => {
    List(x, -x)
  })  // alternative syntax, same as: flatMap(x => List(x, -x))

  // .filter(function)
  val aFilteredList = aList.filter(x => x % 2 == 0)
  println(aFilteredList)

  val alternativeFilteredList = aList.filter(_ % 2 == 0)  // equivalent to .filter(x => x % 2 == 0): just stop repeating x anymore
  println(alternativeFilteredList)

  // find permutation of all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  // flatmap-map chained
  val allPairsList = List(1, 2, 3).flatMap(num => List('a', 'b', 'c').map(letter => s"$num$letter"))
  println(allPairsList)

  // for comprehensions: it is an expression of sugar syntax of flatmap-map chained
  // for {...} yield ...
  val sugarAllPairsList = for {
    num <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$num$letter"
  println(sugarAllPairsList)

  /*
   *  Collections
   */

  // lists: linked list in C++
  val myList: List[Int] = List(1,2,3,4,5)
  val firstElement: Int = myList.head
  val rest: List[Int] = aList.tail
  val aPrependedList = 0 :: myList  // List(0,1,2,3,4,5)
  val aExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3)
  val accessedElement = aSequence(1)  // the element at index 1 = 2

  // vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,1,1,2,3,3,4) // equivalent to Set(1,2,3,4)
  val isFiveInSet = aSet.contains(5)  // false
  val anAddedSet = aSet + 0 // Set(0,1,2,3,4)
  val aRemovedSet = aSet - 0  // Set(1,2,3,4)

  // ranges
  val aRange = 1 to 100 // 1 <= x <= 100
  val anAnotherRange = 1 until 100  // 1 <= x < 100

  val twoByTwo = aRange.map(x => 2 * x).toList  // List(2,4,6,8,..., 2000)

  // tuples: groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook: Map[String, String] = Map(
    "Bank" -> "0614615868",
    "Ploy" -> "0620032376"
  )
}
