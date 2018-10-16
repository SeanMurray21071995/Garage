class Employee (val id:Int, val name:String, val age:Int, val role:String)extends Person{
  var carAssigned: Vehicle = null
override def toString:String = s"Employee: $name \n age: $age \n role: $role"
}
