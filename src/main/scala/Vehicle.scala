abstract class Vehicle {
  val id:Int
  val colour:String
  val wheels:Int
  override def toString:String = s"color:$colour \n wheels:$wheels"
}
