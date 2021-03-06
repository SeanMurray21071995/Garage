import scala.collection.mutable.ListBuffer

class Garage {
  private var vehicleMap=scala.collection.mutable.Map.empty[Int,Vehicle]
  private var employeeMap=scala.collection.mutable.Map.empty[Int,Employee]
  private var clockedIn:ListBuffer[Employee] = ListBuffer.empty

  def removeVehicle(removeParameter:Any):Unit = removeParameter match {
    case removeParameter: Int=> vehicleMap-=removeParameter
    case removeParameter: String=> vehicleMap=vehicleMap.filter(element => element._2.getClass.getName!=removeParameter)  //=vehicleMap.filter(element => !element._2.isInstanceOf[Car])
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
  def calculateBill(vehicle: Vehicle):Double={
     val actualCost=vehicle.partList.map(_.fixTime).sum*4.99
     vehicleMap.get(vehicle.id) match{
       case Some(value) if value.estimatedCost<=actualCost=> (actualCost/100)*90
       case Some(value) => actualCost
       case None=> 0
     }
  }
  def isGarageOpen():Boolean={
    if(clockedIn.isEmpty)false else true
  }
  def clockIn(employee: Employee):Unit={      // potentialy combine this method for my adding removing to the list method
  if (clockedIn.contains(employee))
      clockedIn-=employee
  else
    clockedIn+=employee
  }
}
