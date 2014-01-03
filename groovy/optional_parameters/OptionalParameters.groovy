/**
 * base is default
 */
def log(x, base=10) {
  Math.log(x) / Math.log(base)
}
assert(log(1024) == log(1024, 10))
assert(log(1024, 2) == 10.0)


/**
 * Name is untyped, Details is a String Array can be used as a varargs
 */
def task(name, String[] details) {
  return "$name - $details"
}

assert((task ('Call Mom', '200-122-1222')) == 'Call Mom - [200-122-1222]')
assert((task ('Call Dad', '914-456-7890 (Work)', '202-122-3002 (Cell)')) == 'Call Dad - [914-456-7890 (Work), 202-122-3002 (Cell)]')
assert((task ('Check Mail')) == "Check Mail")



