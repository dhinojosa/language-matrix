package com.evolutionnext.challenges.caesarshift

object CaesarShift extends App {
    val LARGE_A = 'A'
    val SMALL_A = 'a'
    val ALPHA_SIZE = 26

    def shiftString(s: String, shift: Int) = {
        def shiftChar(c: Char) =
            if (!Character.isAlphabetic(c)) c
            else {
                val preferredA = if (c.isUpper) LARGE_A else SMALL_A;
                ((c - preferredA + (shift % ALPHA_SIZE + ALPHA_SIZE)) %
                    ALPHA_SIZE + preferredA).toChar;
            }

        s map shiftChar
    }

    def encode(s: String, shift: Int) = shiftString(s, shift)
    def decode(s: String, shift: Int) = shiftString(s, -shift)

    shiftString(shiftString("Zebras are cool!", 2), -2)
    shiftString(shiftString("Zebras are cool!", 230239), -230239)
}
