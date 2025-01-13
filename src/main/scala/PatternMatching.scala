object PatternMatching extends App {
  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)

  // pattern matching is an EXPRESSION

  // case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43)
  val personGreeting = bob match {
    case Person(name, age) => s"Hi my name is $name. I am $age y/o."
    case _ => "something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Body Slam", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre."
    case _ => "I don't know what you're talking about"
  }
  println(bandDescription)

  // decomposing lists
  val aList = List(1,2,3)
  val aListDescription = aList match {
    case List(_, 2, _) => s"List containing 2 on tis second position"
    case _ => "unknown list"
  }
  println(aListDescription)

  // if pattern matching doesn't match anything, it will throw a MatchError
  // pattern matching will try all cases in sequence
}
