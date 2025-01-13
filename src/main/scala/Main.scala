object Main {
  def greeting(): Unit = println("Hi guy")

  def main(args: Array[String]): Unit = {
    println("Hello world!")

    greeting()

    val nums = Array(2, 7, 11, 15)
    val target = 9
    val result = Solution.twoSum(nums, target)
    println(result.mkString(", "))

    for {
      idx <- result
    } yield println(idx)
  }
}