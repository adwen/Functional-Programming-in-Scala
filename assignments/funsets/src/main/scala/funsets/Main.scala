package funsets

object Main extends App {
  import FunSets._
  def f1: Int => Boolean = x => x > 0 && x < 4
  def s2: Int => Int = x => 2 * x
  def s3 = map(x => x > 0 && x < 4, x => 2 * x)
  def s4: Int => Boolean =  y => contains(f1, y) && s2(y) == y
  printSet(f1)
  printSet(s3)

}
