package scala

object PowerOfTwo {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n <= 0) return false
    if ((n & n - 1) == 0) return true
    false
  }

  def main(args: Array[String]): Unit = {
    isPowerOfTwo(2)
  }
}
