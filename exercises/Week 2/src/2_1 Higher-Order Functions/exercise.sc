def product(f: Int  => Int, lower: Int, upper: Int): Int = {
  def tailProduct(num: Int, acc: Int): Int =
    if (num > upper) acc
    else tailProduct(num + 1, f(num) * acc)
  tailProduct(lower, 1)
}

product(x => x + x, 3 , 6)

def factorial(num: Int) =
  product(x => x, 1, num)

factorial(4)

// cannot write more general function for sum and product
// because the starting accumulator for sum is 0 and product is 1