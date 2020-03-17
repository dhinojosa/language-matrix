class Employee(fn:String, ln:String) {
 
  private val _fn = fn
  private val _ln = ln

  def firstName = _fn
  def lastName = _ln

 // def firstName_=(x:String) {_fn = x}
 // def lastName_=(x:String) {_ln = x}

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
