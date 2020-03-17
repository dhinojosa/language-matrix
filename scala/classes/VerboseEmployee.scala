class Employee() {

  private var fn:String = _
  private var ln:String = _

  def this(firstName:String, lastName:String) = {
    this()
    this.fn = firstName
    this.ln = lastName
  }

  def firstName = fn
  def lastName = ln

  def firstName_=(x:String) {fn = x}
  def lastName_=(x:String) {ln = x}

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
