def and(x: Boolean, y: Boolean) : Boolean =
  if (x)
    if (y) true
    else false
  else false

def or(x: Boolean, y: Boolean) : Boolean =
  if (x) true
  else if (y) true
  else false


and(x = true, y = false)
// return false
and(x = false, y = false)
// return false
and(x = true, y = true)
// return true
and(x = false, y = true)
// return false
or(x = true, y = false)
or(x = false, y = false)
// return false
or(x = true, y = true)
// return true
or(x = false, y = true)
// return true

