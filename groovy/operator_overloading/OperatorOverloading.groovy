class Employee {
   int id
   String firstName, lastName
   Employee() {}
}

class Department {
   def id
   def name
   def employeeMap = [:]

   Department() {}
   Department(int id, String name) {
     this.id = id
     this.name = name
   }

   def hire(employee) {employeeMap.put(employee.id, employee)}
   def fire(employee) {employeeMap.remove(employee.id)}

   def plus(employee) {
     hire(employee)
   }

   def minus(employee) {
     fire(employee)
   }

   def leftShift(employee) {
     hire(employee)
     return this
   }
}

def sales = Department(3,"Sales")
sales + Employee(id:1, firstName:"Bill", lastName:"Gates")
