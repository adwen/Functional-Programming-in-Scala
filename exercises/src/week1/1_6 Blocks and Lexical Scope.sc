def sqrt(x: Double) = {
  def abs(x:Double) = if (x < 0) -x else x
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))
  def improve(guess: Double) =
    (guess + x / guess) / 2
  def isGoodEnough(guess: Double) =
    abs(guess * guess - x) / x < 0.001
  sqrtIter(1.0)
}

sqrt(.001)
sqrt(.1e-20)
sqrt(1.0e20)
sqrt(1.0e50)
sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)