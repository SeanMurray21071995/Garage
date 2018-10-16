class Parts (val id:Int, var state:String, var fixTime:Int){
  override def toString:String= s"Id: $id \n state: $state \n fixTime: $fixTime"
}
