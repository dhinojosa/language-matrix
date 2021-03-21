#[cfg(test)]
mod variables {
    /* Variable let is immutable
     * and cannot be reassigned.
     * Variable are immutable by default
     **/
    #[test]
    fn test_let() {
        let a = 40;
        assert!(a == 40);

        //a = 390; This cannot be done
    }

    /*
     * We can use the `mut` keyword when expressing
     * mutability
     */
    #[test]
    fn test_mutablelet() {
        let mut a = 40;
        assert!(a == 40);
        a = 50;
        assert!(a == 50)
    }

    /*
     * You are not allowed to use mut with a const
     * You declare const instead of let
     * Type must be annotated
     * You always need to annotated the type
     * They can be declared in any scope including global?
     *
     */

    const MY_VALUE: u32 = 40_102_201;

    #[test]
    fn test_const() {
        assert!(MY_VALUE == 40_102_201);
    }


    /*
     * Variables can be shadowed
     */

    #[test]
    fn test_shadowing() {
        let x = 5;
        let x = x + 1;
        let x = x * 2;

        assert!(x == 12)
    }

    /*
     * We cannot change the type with mut
     * variables are type sensitive
     */
    #[test]
    fn test_changing_type() {
        //let mut str = "hello";
        // str = str.len() error
        assert!(true)
    }
}
