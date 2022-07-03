package com.evolutionnext.biginteger;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BigIntegerTest {
    @Test
    void testBigInteger() {
        //Integer primitives and their wrappers can only go from
        //−4294967296 (-2⁽³²⁻¹⁾)
        assertThat(java.lang.Integer.MIN_VALUE).isEqualTo(-2147483648);

        // to 4294967295 or (2⁽³²⁻¹⁾-1)
        assertThat(java.lang.Integer.MAX_VALUE).isEqualTo(2147483647);

        // any attempt to put a larger number may result in a compilation error

        // or an overflow, sometimes creating a negative
        //noinspection NumericOverflow
        assertThat(java.lang.Integer.MAX_VALUE + 30).isLessThan(0);

        //java.lang.BigInteger is a class used to create large integers without
        //such a bound and be able even perform mathematical operations on those
        //large numbers, NOTE: Use a string to create a BigInteger.

        BigInteger typicalMaxInteger = new BigInteger("2147483647");

        assertThat(typicalMaxInteger).isEqualTo(new BigInteger("2147483647"));
    }
}
