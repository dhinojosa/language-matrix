#[cfg(test)]
mod operators {
    /**
     * If the implementation overrides an Add method then it is possible to add
     */
    #[test]
    fn test_add() {
        const Z: u32 = 1203 + 3012;
        assert_eq!(Z, 4215);
    }

    #[test]
    fn test_subtract() {
        const Z: u32 = 22 - 11;
        assert_eq!(Z, 11);
    }

    #[test]
    fn test_multiply() {
        const Z: u32 = 22 * 10;
        assert_eq!(Z, 220);
    }

    #[test]
    fn test_divide() {
        const Z: u32 = 10 / 2;
        assert_eq!(Z, 5);
    }

    #[test]
    fn test_mod() {
        const Z: u32 = 10 % 3;
        assert_eq!(Z, 1);
    }
}
