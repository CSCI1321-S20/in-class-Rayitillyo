package mud

class Room(val name: String, val desc: String, private var items: List[Item], private val exits: Array[String]) {


  def description(): String = {
    //Builds and returns entire description of the room including the present items
    var d = desc + "\nThe following items are in the room: "
    for(i <- items) d = d + i.name + " "
    d = d + "\n"
    d
 }

  def getExit(dir: Int): Option[Room] = 
  {
    //0 => up 1 => down 2 => left 3=> right  4=> front 5 => back
    if(!exits(dir).isEmpty) Room.find(_.name == exits(dir))
    else None
  }

  def getItem(itemName: String): Option[Item] = {
    //pull item from the room and return it otherwise return nothing
    items.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        items = items.filter(_ != item)
        Some(item)
      case None => None
    }
  }

  def dropItem(item: Item): Unit = items ::= item
}

object Room {
  val rooms = readRooms()

  def readRooms(): Array[Room] = {
    val source = scala.io.Source.fromFile("world.txt")
    val lines = source.getLines()
    val r = Array.fill(lines.next.toInt)(readRoom(lines))
    source.close()
    r
  }

  def readRoom(lines: Iterator[String]): Room = ???
}