import week3._

def nth[T](n: Int, list: List[T]): T = {
  @scala.annotation.tailrec
  def tail_nth[T](n: Int, xs: List[T], curr: T): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) curr
    else tail_nth(n - 1, xs.tail, xs.head)
  tail_nth(n, list, list.head)
}

val list = new Cons(1, new Cons( 2, new Cons(3 , new Nil)))

nth(2, list)
nth(-4, list)