import java.math.BigInteger;
import java.math.BigDecimal;

public class BigIntegersDecimals { 

   public static void main(String[] args) {
      //Integer primitives and their wrappers can only go from 
      //−4294967296 (-2⁽³²⁻¹⁾)
      assert(java.lang.Integer.MIN_VALUE == -2147483648); 

      // to 4294967295 or (2⁽³²⁻¹⁾-1)
      assert(java.lang.Integer.MAX_VALUE == 2147483647);

      // any attempt to put a larger number may result in a compilation error

      // or an overflow, sometimes creating a negative
      assert(java.lang.Integer.MAX_VALUE + 30 < 0);

      //java.lang.BigInteger is a class used to create large integers without
      //such a bound and be able even perform mathematical operations on those
      //large numbers, NOTE: Use a string to create a BigInteger.

      BigInteger typicalMaxInteger = new BigInteger("2147483647");

      assert(typicalMaxInteger.equals(new BigInteger("2147483647")));

   }
}
