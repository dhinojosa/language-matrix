class Employee(val firstName:String, val lastName:String) {
 
  def firstName_=(x:String) = new Employee(x, lastName)
  def lastName_=(x:String) = new Employee(firstName, x)

  override def equals(x:Any) = {
    if (!(x.isInstanceOf[Employee])) false
    else {
      val other = x.asInstanceOf[Employee]
      other.firstName.equals(other.firstName) &&
      other.lastName.equals(other.lastName)
    }
  }

  override def hashCode = (firstName.hashCode + lastName.hashCode) ^ 101

  override def toString = s"Employee($firstName, $lastName)"
}
