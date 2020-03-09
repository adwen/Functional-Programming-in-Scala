package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r == 0 || r == c) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    // ( = 1
    // ) = -1
    def determineParenthesis(char: Char) =
      if (char == '(') 1
      else if (char == ')') -1
      else 0
    @scala.annotation.tailrec
    def tailBalance(chars: List[Char], state: Int): Int =
      if (chars.isEmpty) state
      else if (determineParenthesis(chars.head) + state == -1) -1
      else tailBalance(chars.tail, state + determineParenthesis(chars.head))
    tailBalance(chars, 0) == 0
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def tailCountChange(money: Int, coins: List[Int], num_ways: Int): Int =
      if (money == 0 || coins.isEmpty) 0
      else if (money - coins.head == 0) 1
      else if (money - coins.head < 0) tailCountChange(money, coins.tail, 0) + num_ways
      else tailCountChange(money - coins.head, coins, 0) +
        tailCountChange(money, coins.tail, 0) + num_ways
    tailCountChange(money, coins.sorted, 0)
  }

}
