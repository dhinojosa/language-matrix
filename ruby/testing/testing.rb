
require "test/unit"

class SimpleTestCase < Test::Unit::TestCase
   def test_simple_add
     assert_equal(4, 2 + 2)
   end
end
