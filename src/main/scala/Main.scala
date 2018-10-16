object Main extends App {
  val i = new Garage
  val c = new Car(1,"Blue",4, "Ford")
  i.addToMap(1,c)
  i.showVehicleList()
  i.removeVehicle("Car")
  i.showVehicleList()
}
