object Main extends App {
  val i = new Garage
  val c = new Car(1,"Blue",4, 22.3,"Ford")
  val c2 = new Car(2,"Green", 4,45.4,"Corsa")
  i.addToMap(1,c)
  i.addToMap(2,c2)
  i.showVehicleList()
  i.removeVehicle("Car")
  i.showVehicleList()
}
