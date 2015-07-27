
def assert(actual, expected)
   raise "Assertion failed. Expected #{expected} but was #{actual}" unless (actual == expected)
end
