class Car(val colour: String, val wheels:Int, makeModel:String) extends Vehicle {
  override def toString: String = s"colour:$colour \n wheels:$wheels \n makeModel:$makeModel"
}
