#[cfg(test)]
mod datatypes {
    use std::str::SplitN;

    #[test]
    fn test_item() {
        let _good = "401";
        let n: SplitN<&str> = _good.splitn(1, "\\d");
        n.for_each(|x| println!("{}\n", x))
    }

    #[test]
    fn test_decimal() {
        let decimal = 65.4321_f32;
        assert!(decimal == 65.4321_f32);
    }

    #[test]
    fn test_casting() {
        let decimal = 65.4321_f32;
        let u8value = decimal as u8;
        assert!(u8value ==  65_u8);
    }
}
