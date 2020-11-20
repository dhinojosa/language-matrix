package com.evolutionnext.sealed;

import org.junit.jupiter.api.Test;

public class SealedTest {

    @Test
    public String doMatch(Object o) {
        if (o instanceof MySome<?> ms) {
            return ms.getValue().toString();
        } else if (o instanceof MyNone mn) {
            return mn.toString();
        }
        return "Avoid";
    }


    // What may be possible
    // https://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html
    @Test
    void patternMatchWithSealedClass() {
        String result = doMatch(new MySome<>(40));
        System.out.println(result);
    }
}
