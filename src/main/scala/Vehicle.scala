abstract class Vehicle {
  val id:Int
  val colour:String
  val wheels:Int
  val estimatedCost: Double
  var fixed:Boolean=false
  override def toString:String = s"color:$colour \n wheels:$wheels"
}
