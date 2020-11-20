
#[cfg(test)]
mod arrays {


    /**
    * Arrays must have all the same type, array are placed in
    * stack rather than a heap. Arrays are not flexible. Arrays are
    * used for collecting items that _are rarely going to change_
    * The type signature `[i32; 5]` represents the type and the length
    * of the array
    */
    #[test]
    fn test_arrays() {
        let array = [1,2,3,4,5];
        assert!(array == [1,2,3,4,5]);
    }


    /**
     * We can initialize the array with `[3, 5]` where 3 is the initial
     * element and 5 is the repeat number
     **/
    #[test]
    fn test_initializing_the_array_with_the_same_element() {
        let array = [3;5];
        assert!(array == [3,3,3,3,3]);
    }

    /**
     * We can access the elements using a `[idx]`
     **/
    #[test]
    fn test_accessing_elements() {
        let array = [1,2,3,4,5];
        let result = array[3];
        assert!(result == 4);
    }
}
