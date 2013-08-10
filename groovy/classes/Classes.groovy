class Employee {
  String firstName, lastName
    
  Employee(firstName, lastName) {
    this.firstName = firstName
    this.lastName = lastName
  }

  def firstName = {this.firstName}
  def lastName = {this.lastName}
}

def bill = new Employee(firstName: "Bill", lastName: "Gates")
assert(bill.firstName == "Bill")
assert(bill.lastName == "Gates") 

def steve = new Employee("Steve", "Jobs")
assert(steve.firstName == "Steve")
assert(steve.lastName == "Jobs") 

