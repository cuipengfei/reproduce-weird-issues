package cpf.coalboss

object CoalBoss {
  def loadTrucks(piles: Seq[CoalPile]): Seq[CoalTruck] = {
    loadPileByPile(piles, List(CoalTruck(List())))
  }

  private def loadPileByPile(piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    if (piles.isEmpty) {
      trucks
    }
    else {
      if (!trucks.last.isFull) {
        if (trucks.last.spaceLeft == piles.head.weight) {
          val loadedTruck = trucks.last.load(piles.head)
          loadPileByPile(piles.tail, trucks.dropRight(1) :+ loadedTruck :+ CoalTruck(List()))
        }
        else if (trucks.last.spaceLeft > piles.head.weight) {
          val notFullyLoadedTruck = trucks.last.load(piles.head)
          loadPileByPile(piles.tail, trucks.dropRight(1) :+ notFullyLoadedTruck)
        }
        else {
          val (splitPile, remainingPile) = piles.head.split(trucks.last.spaceLeft)
          val loadedTruck = trucks.last.load(splitPile)
          loadPileByPile(piles.tail :+ remainingPile, trucks.dropRight(1) :+ loadedTruck :+ CoalTruck(List()))
        }
      } else {
        loadPileByPile(piles, trucks :+ CoalTruck(List()))
      }
    }
  }
}
