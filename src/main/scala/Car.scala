class Car(val id:Int, val colour: String, val wheels:Int, val estimatedCost: Double,makeModel:String) extends Vehicle {
  override def toString: String = s"colour:$colour \n wheels:$wheels \n makeModel:$makeModel \n estimatedCost:$estimatedCost"
}
