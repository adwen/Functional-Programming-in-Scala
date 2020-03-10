def product(f: Int => Int)(lower: Int, upper: Int): Int = {
  def tailProduct(num: Int, acc: Int): Int =
    if (num > upper) acc
    else tailProduct(num + 1, f(num) * acc)
  tailProduct(lower, 1)
}

product(x => x + x)(3, 4)

def factorial(num: Int) =
  product(x => x)( 1, num)

factorial(5)

def mapReduce(f: Int => Int, g: (Int, Int) => Int, zeroVal: Int)
             (lower: Int, upper:Int): Int = {
  def tailMapReduce(num: Int, acc: Int): Int =
    if (num > upper) acc
    else tailMapReduce(num + 1, g(f(num), acc))
  tailMapReduce(lower, zeroVal)
}

def mapProduct(f: Int => Int)(lower: Int, upper: Int) =
  mapReduce(f, (x,y) => x * y, 1)(lower, upper)

mapProduct(x => x + x)(3, 4)