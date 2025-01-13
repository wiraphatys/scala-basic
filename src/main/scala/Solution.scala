import scala.util.control.Breaks
import scala.util.control.Breaks.break

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var result = Array(-1, -1)
    Breaks.breakable {
      nums.zipWithIndex.foldLeft(Map[Int, Int]()) { (memo, numWithIdx) =>
        val (num, idx) = numWithIdx
        val complement = target - num
        if (memo.contains(complement)) {
          result = Array(memo(complement), idx)
          break()
        }
        memo + (num -> idx)
      }
    }

    result
  }
}