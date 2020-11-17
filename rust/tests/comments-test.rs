//A single line comment
#[cfg(test)]
mod comments {

// A multiline comment with slashes
// Here is another line

    /**
    * Here is a multiline comment that is above a method
    */
    #[test]
    fn test_casting() {
        let decimal = 65.4321_f32;
        let u8value = decimal as u8; // A comment at the end of the line here
        assert!(u8value == 65_u8);
    }
}
