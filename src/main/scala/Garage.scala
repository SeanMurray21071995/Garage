import scala.collection.mutable.ListBuffer

class Garage {
  private var vehicleMap=scala.collection.mutable.Map.empty[Int,Vehicle]
  private var employeeMap=scala.collection.mutable.Map.empty[Int,Employee]
  private var clockedIn:ListBuffer[Employee] = ListBuffer.empty

  def removeVehicle(removeParameter:Any):Unit = removeParameter match {
    case removeParameter: Int=> vehicleMap-=removeParameter
    case removeParameter: String=> vehicleMap=vehicleMap.filter(element => element._2.getClass.getName!=removeParameter)//=vehicleMap.filter(element => !element._2.isInstanceOf[Car])
  }
  def showVehicleList():Unit={
    vehicleMap.foreach(println)
  }
  def addToMap[T](id:Int,inputVariable:T):Unit={
    inputVariable match {
      case vehicle: Vehicle => vehicleMap+=(id->vehicle)
      case employee: Employee if employeeMap contains(id) => employeeMap updated (id,employee)
      case employee: Employee => employeeMap+=(id->employee)
    }
  }
  def assignJob(employee: Employee, vehicle: Vehicle):Unit={
    addToMap(employee.id, employee.carAssigned=vehicle)
  }
  def jobComplte(employee: Employee):Unit={
    addToMap(employee.carAssigned.id, employee.carAssigned.fixed=true)
  }
  def calculateBill(vehicleId:Int, actualCost:Double):Double={
     vehicleMap.get(vehicleId) match{
       case Some(value) if value.estimatedCost<=actualCost=> (actualCost/100)*80
       case Some(value) => actualCost
       case None=> 0
     }
  }
  def isGarageOpen():Boolean={
    if (clockedIn.isEmpty)
      false
    else
      true
  }
  def clockIn(employee: Employee):Unit=  {
  if (clockedIn.contains(employee))
      clockedIn-=employee
  else
    clockedIn+=employee
  }
  def calculateRepairTime(vehicle: Vehicle):Int={
    val tempList =vehicle.partList.filter(element=> element.state=="Broken")
    var sum:Int=0
    for(i<-0 to tempList.length-1) sum+=tempList(i).fixTime
    sum
  }
}
