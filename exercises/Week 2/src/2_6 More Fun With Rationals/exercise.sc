class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be greater than 0")

  def this(x: Int) = this(x, 1)

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  // do whatever is in comments as it'll keep arithmetic small
  // def numer = x / gcd(x, y)
  def numer = x
  // def numer = y / gcd(x, y)
  def denom = y

  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg() =
    new Rational(-numer, denom)

  def sub(that: Rational) =
    add(that.neg())

  def less(that: Rational) =
    if (numer * that.denom < that.numer * denom) true
    else false

  def max(that: Rational) =
    if (this.less(that)) that
    else this

  // do not do gcd in toString as arithmetic errors will appear while
  // dealing with large numbers
  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}

val xs = new Rational(1, 2)
xs.numer
xs.denom
val ys = new Rational(2, 3)
xs.add(ys)

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.neg()
x.sub(y).sub(z)
y.add(y)
x.less(y)
x.max(y)
new Rational(2)


