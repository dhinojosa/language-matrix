/**
 * To create a class in groovy it is assumed that all classes are public
 * Semicolons are optional
 * Parenthesis are optional
 * If you don’t specify an access modifier, attributes are assumed to be private,
 *    and methods are assumed to be public.
 */
class Employee {
  //Fields are already encapsulated, getters and setters are automatically created
  String firstName, lastName

  /**
   * A default no args constructor is required if you are to use a map construction
   */
  Employee() {} 

  /**
   * An ancillary constructor that takes a firstName and a lastName
   **/
  Employee(firstName, lastName) {
    this.firstName = firstName
    this.lastName = lastName
  }

  // def firstName = {this.firstName}
  // def lastName = {this.lastName}
}


/**
 * "def" is a replacement for a type name.
 * It is used to indicate that you don't care about the type.
 * It is mandatory to either provide a type name explicitly or to use "def" in replacement. This is needed to the make variable definitions detectable for the Groovy parser.
 * These definitions may occur for local variables in a script or for local variables and properties/fields in a class.
 * You can think of "def" as an alias of "Object" and you will understand it in an instant.
 * "def" can also replace "void" as the return type in a method definition.
 */
def bill = new Employee(firstName: "Bill", lastName: "Gates") // named parameter
assert(bill.firstName == "Bill")
assert(bill.lastName == "Gates")

/**
  * The assert keyword
  * Groovy asserts are an easy way to verify correctness. 
  * An assert returns nothing if the expression is true, and prints a detailed error message if it’s not.
  */
def larry = new Employee(lastName: "Page", firstName: "Larry")
assert(larry.firstName == "Larry")
assert(larry.lastName == "Page")


def steve = new Employee("Steve", "Jobs")
assert(steve.firstName == "Steve")
assert(steve.lastName == "Jobs") 

/**
 * Using a map to create an object using the keyword 'as'
 */
def sergei = [firstName:"Sergei", lastName:"Brin"] as Employee
assert(sergei.firstName == "Sergei")
assert(sergei.lastName == "Brin")

