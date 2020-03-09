def product(f: Int => Int, lower: Int, upper: Int) : Int =
  if (lower > upper) 1
  else f(lower) * product(f, lower + 1 , upper)

product(x => x * x, 3, 4)