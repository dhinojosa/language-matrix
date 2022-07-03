#[cfg(test)]
mod datatypes {
    #[test]
    fn test_decimal() {
        let decimal = 65.4321_f32;
        assert!(decimal == 65.4321_f32);
    }

    #[test]
    fn test_casting() {
        let decimal = 65.4321_f32;
        let u8value = decimal as u8;
        assert!(u8value == 65_u8);
    }

    /**
    *  i8 is a signed byte type, must be between 127 and -128
    */
    #[test]
    fn test_integer_i8() {
        let b: i8 = 127;
        assert!(b == 127);

        let c: i8 = -128;
        assert!(c == -128);
    }

    /**
    *  i16 is a signed short type, must be between 32766 and -32767
    */
    #[test]
    fn test_integer_i16() {
        let b: i16 = 32766;
        assert!(b == 32766);

        let c: i16 = -32767;
        assert!(c == -32767);
    }

    /**
     *  i32 is a signed int type, must be between 2147483646 and -2147483647
     */
    #[test]
    fn test_integer_i32() {
        let b: i32 = 2147483646;
        assert!(b == 2147483646);

        let c: i32 = -2147483647;
        assert!(c == -2147483647);
    }

    /**
     *  i64 is a signed int type, must be between 2147483646 and -2147483647
     */
    #[test]
    fn test_integer_i64() {
        let b: i64 = 9_223_372_036_854_775_807;
        assert!(b == 9_223_372_036_854_775_807);

        let c: i64 = -9_223_372_036_854_775_808;
        assert!(c == -9_223_372_036_854_775_808);
    }

    /**
     *  i128 is a signed int type, must be between 2147483646 and -2147483647
     */
    #[test]
    fn test_integer_i128() {
        let b: i128 = 170_141_183_460_469_231_731_687_303_715_884_105_727;
        assert!(b == 170_141_183_460_469_231_731_687_303_715_884_105_727);

        let c: i128 = -170_141_183_460_469_231_731_687_303_715_884_105_728;
        assert!(c == -170_141_183_460_469_231_731_687_303_715_884_105_728);
    }

    /**
     *  The size of this primitive is how many bytes it takes to reference any location
     *  in memory. For example, on a 32 bit target, this is 4 bytes and on a 64 bit target,
     *  this is 8 bytes
     */
    #[test]
    fn test_arch_isize() {
        let b: isize = 9_223_372_036_854_775_807;
        assert!(b == 9_223_372_036_854_775_807);

        let c: isize = -9_223_372_036_854_775_808;
        assert!(c == -9_223_372_036_854_775_808);
    }


    /**
    *  u8 is an unsigned byte type, must be between 0 and 255?
    */
    #[test]
    fn test_integer_u8() {
        let b: u8 = 255;
        assert!(b == 255);

        let c: u8 = 0;
        assert!(c == 0);
    }

    /**
     *  u16 is an unsigned short type, must be between 0 and 65_535?
     */
    #[test]
    fn test_integer_u16() {
        let b: u16 = 65_535;
        assert!(b == 65_535);

        let c: u8 = 0;
        assert!(c == 0);
    }

    /**
    *  u32 is an unsigned int type, must be between 0 and 4_294_967_295?
    */
    #[test]
    fn test_integer_u32() {
        let b: u32 = 4_294_967_295;
        assert!(b == 4_294_967_295);

        let c: u32 = 0;
        assert!(c == 0);
    }

    /**
     *  u64 is an unsigned long type, must be between 0 and 18_446_744_073_709_551_615?
     */
    #[test]
    fn test_integer_u64() {
        let b: u64 = 18_446_744_073_709_551_615;
        assert!(b == 18_446_744_073_709_551_615);

        let c: u64 = 0;
        assert!(c == 0);
    }


    /**
     *  u128 is an unsigned super-long type, must be between 0 and
     *  340_282_366_920_938_463_463_374_607_431_768_211_455?
     */
    #[test]
    fn test_integer_u128() {
        let b: u128 = 340_282_366_920_938_463_463_374_607_431_768_211_455;
        assert!(b == 340_282_366_920_938_463_463_374_607_431_768_211_455);

        let c: u128 = 0;
        assert!(c == 0);
    }


    /**
     *  The pointer-sized unsigned integer type. Although using these constants won’t cause
     *  compilation warnings, new code should use the associated constants directly on the primitive type.
     */
    #[test]
    fn test_arch_usize() {
        let b: usize = 18_446_744_073_709_551_615;
        assert!(b == 18_446_744_073_709_551_615);

        let c: usize = 0;
        assert!(c == 0);
    }


    /**
     * Hexadecimal is preceded by 0x
     */
    #[test]
    fn test_hex() {
        let b = 0xff;
        assert!(b == 255);
    }

    /**
    * Octal is preceded by 0 and o
    */
    #[test]
    fn test_oct() {
        let b = 0o77;
        assert!(b == 63);
    }

    /**
     * Binary is preceded by 0b
     */
    #[test]
    fn test_binary() {
        let b = 0b1111_0000;
        assert!(b == 240)
    }

    /**
     * Bytes can be used with characters
     */
    #[test]
    fn test_byte() {
        let b = b'A';
        assert!(b == 65);
    }

    /**
     * Floating point comes in f32
     */
    #[test]
    fn test_floating_point_f32() {
        let fp = 302.123 as f32;
        assert!(fp == 302.123)
    }

    /**
   * Floating point comes in f64, which is the default size
   */
    #[test]
    fn test_floating_point_f64() {
        let fp = 302.123;
        assert!(fp == 302.123)
    }


    /**
     * Booleans are just true and false
     */
    #[test]
    fn test_booleans() {
        let c = true;
        assert!(c == true);

        let d = false;
        assert!(d == false)
    }

    /**
     * Chars are in single quotes. four bytes in size and represents a Unicode Scalar Value,
     * which means it can represent a lot more than just ASCII. Accented letters; Chinese,
     * Japanese, and Korean characters; emoji; and zero-width spaces are all valid
     * char values in Rust. Ranges are inclusive: U+0000 to U+D7FF and U+E000 to U+10FFFF
     */
    #[test]
    fn test_characters() {
        let c = 'z';
        let z = 'ℤ';
        let heart_eyed_cat = '😻';

        assert!(c == 'z');
        assert!(z == 'ℤ');
        assert!(heart_eyed_cat == '😻');
    }
}
