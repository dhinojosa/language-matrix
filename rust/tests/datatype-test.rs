#[cfg(test)]
mod datatypes {
    #[test]
    fn test_item() {
        let _good = "401";
        let n = _good.splitn(1, "\\d");
        n.for_each(|x| println!("{}\n", x))
    }
}
