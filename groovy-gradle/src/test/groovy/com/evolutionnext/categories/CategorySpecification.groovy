package com.evolutionnext.categories

import spock.lang.Specification

class CategorySpecification extends Specification {
    def "decorator should apply the new graft methods"() {
        expect:
        use (IntegerDecorator) {
            11.isOdd() && !12.isOdd()
        }
    }
}
