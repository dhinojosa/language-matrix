
def assert(actual, expected)
   raise "Assertion failed. Expected #{expected.to_s} but was #{actual.to_s}" unless (actual == expected)
end
