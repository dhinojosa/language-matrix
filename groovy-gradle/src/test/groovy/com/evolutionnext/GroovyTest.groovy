package com.evolutionnext

import junit.framework.TestCase

class GroovyTest extends GroovyTestCase {
    void testAddition() {
        def result = 1 + 2
        TestCase.assertEquals(3, result)
    }
}
