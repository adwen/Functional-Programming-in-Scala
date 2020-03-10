def factorial(n: Int): Int = {
  def tail_factorial(x: Int, multiplier: Int): Int =
    if (x == 0) multiplier
    else tail_factorial(x - 1, multiplier * x)
  tail_factorial(n, 1)
}

factorial(6)