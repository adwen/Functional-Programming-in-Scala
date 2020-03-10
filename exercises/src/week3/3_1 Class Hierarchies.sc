abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

abstract class Base {
  def foo =  1;
  def bar: Int
}

class Sub extends Base {
  override def foo: Int = 2
  def bar = 3
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else x == elem

  override def toString: String = "{" + left + elem + right + "}"
}

// object vs class
// object singleton (no need to create new instance)
// class create many instances of class 
object Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty(), new Empty())

  override def toString: String = "."
}

val t1 = new NonEmpty(3, new Empty(), new Empty())
val t2 = t1 incl 4