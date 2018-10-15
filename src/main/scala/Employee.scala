class Employee (val name:String, val age:Int, val role:String)extends Person{
override def toString:String = s"Employee: $name \n age: $age \n role: $role"
}
