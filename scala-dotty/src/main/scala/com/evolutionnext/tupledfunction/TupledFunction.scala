package com.evolutionnext.tupledfunction

object TupledFunction extends App {

  val fun = (a1:Int, a2:Int, a3:Int, a4:Int, a5:Int, a6:Int,
  a7:Int, a8:Int, a9:Int, a10:Int, a11:Int, a12:Int,
  a13:Int, a14:Int, a15:Int, a16:Int, a17:Int, a18:Int,
  a19:Int, a20:Int, a21:Int, a22:Int, a23:Int, a24:Int,
  a25:Int, a26:Int, a27:Int, a28:Int, a29:Int, a30:Int) => 
      a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + a14 +
      a15 + a16 + a17 + a18 + a19 + a20 + a21 + a22 + a23 + a24 + a25 + a26 +
      a27 + a28 + a29 + a30

  val result = fun(25, 88, 192, 128, 52, 112, 63, 59, 108, 153, 20, 10, 195,
      114, 77, 34, 115, 114, 171, 72, 164, 121, 80, 67, 97,
      165, 69, 119, 103, 120)

  println(fun)
}
