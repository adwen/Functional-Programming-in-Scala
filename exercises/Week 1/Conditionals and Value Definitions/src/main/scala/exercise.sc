def and(x: Boolean, y: => Boolean) : Boolean =
  if (x) y
  else false

def or(x: Boolean, y: => Boolean) : Boolean =
  if (!x) y
  else true

and(x = true, y = false)
// return false
and(x = false, y = false)
// return false
and(x = true, y = true)
// return true
and(x = false, y = true)
// return false
or(x = true, y = false)
// return true
or(x = false, y = false)
// return false
or(x = true, y = true)
// return true
or(x = false, y = true)
// return true