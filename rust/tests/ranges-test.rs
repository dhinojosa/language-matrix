#[cfg(test)]
mod ranges {
    #[test]
    fn test_ranges() {
        let range = 1..5;
        assert!(range.start == 1);
    }
}
