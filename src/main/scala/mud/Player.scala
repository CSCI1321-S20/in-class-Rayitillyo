package mud

class Player(items:List[Item] = List(), position:Room)
{
    def processCommand(command:String):Unit ={
        
    }

    def getFromInventory(itemName:String):Option[Item]={
        items.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        items = items.filter(_ != item)
        Some(item)
      case None => None
    }
    }

    def addToInventory(item:Item):Unit = items ::= item

    def inventoryListing:String = {
        if(items.isEmpty)
        return "Your inventory is empty."
        else {
        var i = "The following items are in your inventory: "
        for(inv <- items) i = i + inv.name + " "
        i = i + "\n"\
        }
    }

    def move(dir:String):Unit = {
        
    }
}