@groovy.transform.Canonical
class Person {
   String firstName
   String lastName
   def propertyMissing(name) {
      "Call property $name in Person"
   }
}

Person person = new Person("Mary", "Shelley")
assert person.middleName == "Call property middleName in Person"
