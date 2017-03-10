
@groovy.transform.Canonical
class Person {
   String firstName
   String lastName
   def methodMissing(String name, Object args) {
      "Call method $name in Person with the args: $args"
   }
}

Person person = new Person("Mary", "Shelley")
assert person.hello("Frankenstein", "The Last Man", "Valperga") == "Call method hello in Person with the args: [Frankenstein, The Last Man, Valperga]"
