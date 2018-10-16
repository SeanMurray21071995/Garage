class Bike(val id:Int, val colour:String, val wheels:Int, val bikeType:String) extends Vehicle {
  override def toString: String = s"colour:$colour \n wheels:$wheels \n bikeType:$bikeType"
}
