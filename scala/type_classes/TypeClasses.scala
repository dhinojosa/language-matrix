


def first[A, B, C](x:(A,B,C)) = x._1
def first[A, B](x:(A,B)) = x._1

println(first((3, "Three", 3.0)))
println(first((3, "Three")))
