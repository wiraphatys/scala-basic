object ObjectOrientation extends App {
  // Scala is an Object Oriented language (OOP)

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    def eat() = println("I'm eating.")
  }
  val anAnimal = new Animal

  // inheritance
  // constructor arguments are NOT fields: so you need to put a "val" before the constructor args
  class Dog(val name: String) extends Animal  // constructor definition
  val aDog = new Dog("Lassie")
  aDog.eat()
  aDog.name

  abstract class WalkingAnimal {
    val hasLeg = true // public by default: can set to private , protected
    def walk(): Unit
  }

  // interface = ultimate abstract type
  // trait = interface in others language
  trait Runnable {
    def run(): Unit
    def warmUp(): Unit
  }

  trait Killable {
    def dead(): Unit
  }

  trait Eatable {
    def eat(food: String): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  // with: keyword to implement the trait and we can multiple implement also.
  class Tiger(val alias: String) extends Animal
    with Runnable
    with Killable
    with Eatable
    with Philosopher {
    override def run(): Unit = println("I am running . . .")

    override def warmUp(): Unit = println("I am warming up and ready to run.")

    override def dead(): Unit = println("I am dead . . .")

    override def eat(food: String): Unit = println(s"I am eating $food")

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  val aTiger = new Tiger("king of tiger")
  aTiger.eat("chicken")
  aTiger eat "chicken"  // infix notation = object method argument, only available for methods with ONE argument
  aTiger ?! "What if we could fly ?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val lion = new Eatable {
    override def eat(food: String): Unit = println(s"lion is eating $food")
  }
  lion.eat("zebra")

  // singleton object: static class/method
  object MySingleton {
    val mySpecialValue = 11111
    def mySpecialMethod(): Int = 7145
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(99)
  MySingleton(99) // equivalent to MySingleton.apply(99)

  // magic with method: apply
  class Product(val name: String, val price: Double)
  object Product {
    // apply method, must implement in companion class only (just implement in object not the class)
    def apply(name: String, price: Double): Product = new Product(name, price)
  }
  val myProduct = Product("Macbook Pro M2", 73900)  // so you can create the class instance without new keyword.
  myProduct.name
  myProduct.price

  // case class: lightweight data structure with some boilerplate
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 32) // Person.apply("Bob", 32)
  bob.name
  bob.age

  // exception
  try {
    val x: String = null
    x.length
  } catch { // catch(Exception e) {...}
    case e: Exception => println("some faulty error message")
  } finally {
    // execute some code no matter what
    // this block is going to run btw.
    println("running the finally block . . .")
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3)  // List.apply(1,2,3)
  val first = aList.head  // int
  val rest = aList.tail // List[Int]

  val aStringList = List("hello", "scala")  // List.apply("hello", "scala")
  val firstString = aStringList.head  // string

  // Point #1: in Scala we usually operate with IMMUTABLE values / objects.
  // Any modification to an object must return to ANOTHER object.
  /*
    Benefits:
    1) works miracles in multi-threaded/distributed environment
    2) helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse  // returns a NEW list

  // Point #2: Scala is closest to the Objected-Oriented ideal

}
