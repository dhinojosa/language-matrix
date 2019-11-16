package com.evolutionnext.generics.arrays;

import com.evolutionnext.generics.people.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArraysTest {

    //18. Arrays naturally covariant
    @Test
    public void testArraysAreNaturallyCovariant() throws Exception {
        American[] americans = new Massachusettsan[3];
        americans[0] = new Massachusettsan();

        // Keep in mind this is runtime error. At compile time
        // this is still allowed.
        assertThatThrownBy(() -> {
            americans[1] = new Raleighite();
            americans[2] = new Wisconsinite();
        }).isInstanceOf(ArrayStoreException.class);

        American american = americans[0];
        Person person = americans[0];
        Object object = americans[0];

        //The following will not work at compile time
        //Massachusettsan massachusettsan = americans[0];
        //Raleighite raleighite = americans[1];
        //Wisconsinite wisconsinite = americans[2];
    }

    /**
     * 19. Internal Checking for Arrays
     * internal tracking will stop any foreign elements from being added
     * at runtime, this test will fail but won't know about it
     * at compile time.
     */
    @Test
    public void testArrayStoreException() throws Exception {
        Object[] objectArray = new String[10];
        assertThatThrownBy(() -> {
            objectArray[0] = new Long(0L);
        }).isInstanceOf(ArrayStoreException.class);
    }

    /**
     * Case 20: You cannot create a generic array.
     * If it were allowed we can avoid the arrays internal check
     * mechanism.
     */
    @Test
    public void testErasureIssuesWithAnArray() {
        //List<Integer>[] integerList = new ArrayList<String>[10];
    }
}
