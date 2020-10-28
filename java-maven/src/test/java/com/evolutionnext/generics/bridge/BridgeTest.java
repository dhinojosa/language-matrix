package com.evolutionnext.generics.bridge;

import org.junit.jupiter.api.Test;

public class BridgeTest {

    /**
     * The following is an example of a bridge method.
     * When compiled and running javap -p on the Node and MyNode Types you
     * will see a more refined type of the method on MyNode that is created
     * automatically. Run:
     * <p>
     * javap -cp target/classes -p com.xyzcorp.bridge.Node
     */
    @Test
    public void testBridgeMethod() {
        Node base = new MyNode(5); //Assigning to the raw form
        base.setData(40); //Not preferred but should still work
    }
}
