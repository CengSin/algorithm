

object Solution {


  def tribonacci(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1 || n == 2) return 1
    val arr: Array[Int] = new Array[Int](n + 1)
    arr(0) = 0
    arr(1) = 1
    arr(2) = 1
    for (i <- 3 to n) {
      arr(i) = arr(i - 1) + arr(i - 2) + arr(i - 3)
    }
    arr(n)
  }

  def loopSolve(n: Int): Int = {


    var x: Int = 0
    var y: Int = 1
    var z: Int = 1

    for (i <- 3 to n) {
      var oldZ = z
      var oldY = y
      z = z + x + y
      y = oldZ
      x = oldY
    }

    z
  }

  def main(args: Array[String]): Unit = {
    tribonacci(37)
  }
}
