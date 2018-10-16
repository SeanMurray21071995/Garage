abstract class Vehicle {
  val id:Int
  val colour:String
  val wheels:Int
  val estimatedCost: Double
  var fixed:Boolean=false
  val partList = scala.collection.mutable.ListBuffer.empty[Parts]
  for(i<-1 to 10){
    val rand = scala.util.Random.nextInt(1)
    partList+=new Parts(i, if(rand==1)"Broken" else "NotBroken",if(rand==1)scala.util.Random.nextInt(10)else null)
  }
  override def toString:String = s"color:$colour \n wheels:$wheels"
}
