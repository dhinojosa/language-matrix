#[cfg(test)]
mod tuples {

    /**
     * Tuples seems that they are much like in other language
     * dumb containers.  The type notation is (type1, type2, type3)
     **/
    #[test]
    fn test_creation() {
        let tup: (i32, f64, u8) = (500, 6.4, 1);
        assert!(tup == (500, 6.4, 1));
    }

    /**
     * Elements can be retrieved using 0,1,2,3
     * It is 0 based
     */
    #[test]
    fn test_getting_elements() {
        let tup: (i32, f64, u8) = (500, 6.4, 1);
        assert!(tup.0 == 500);
        assert!(tup.1 == 6.4);
        assert!(tup.2 == 1);
    }

    /**
     * Elements can be retrieved using 0,1,2,3
     * It is 0 based
     */
    #[test]
    fn test_elements_getting_destructured() {
        let (fst, snd, thd) = (500, 6.4, 1);
        assert!(fst == 500);
        assert!(snd == 6.4);
        assert!(thd == 1);
    }
}
