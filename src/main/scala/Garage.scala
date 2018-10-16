class Garage {
  private var vehicleMap=scala.collection.mutable.Map.empty[Int,Vehicle]
  private var employeeMap=scala.collection.mutable.Map.empty[Int,Employee]

  def addVehicle(vehicle: Vehicle):Unit={
    vehicleMap+=(vehicle.id ->vehicle)
  }
  def removeVehicle(removeParameter:Any):Unit = removeParameter match {
    case removeParameter: Int=> vehicleMap-=removeParameter
    case removeParameter: String=> vehicleMap=vehicleMap.filter(element => element._2.getClass.getName!=removeParameter)//=vehicleMap.filter(element => !element._2.isInstanceOf[Car])
  }
  def showVehicleList():Unit={
    println("The map :"+vehicleMap)
  }
  def addToMap[T](id:Int,inputVariable:T):Unit={
    inputVariable match {
      case vehicle: Vehicle => employeeMap+=(id->inputVariable[Vehicle])
    }
  }
}
