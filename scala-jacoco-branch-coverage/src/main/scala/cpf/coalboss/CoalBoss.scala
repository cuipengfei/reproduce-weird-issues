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
      val lastTruck = trucks.last
      val firstPile = piles.head
      
      if (!lastTruck.isFull) {
        if (lastTruck.spaceLeft == firstPile.weight) {
          val loadedTruck = lastTruck.load(firstPile)
          loadPileByPile(piles.tail, trucks.dropRight(1) :+ loadedTruck :+ CoalTruck(List()))
        }
        else if (lastTruck.spaceLeft > firstPile.weight) {
          val notFullyLoadedTruck = lastTruck.load(firstPile)
          loadPileByPile(piles.tail, trucks.dropRight(1) :+ notFullyLoadedTruck)
        }
        else {
          val (splitPile, remainingPile) = firstPile.split(lastTruck.spaceLeft)
          val loadedTruck = lastTruck.load(splitPile)
          loadPileByPile(piles.tail :+ remainingPile, trucks.dropRight(1) :+ loadedTruck :+ CoalTruck(List()))
        }
      } else {
        loadPileByPile(piles, trucks :+ CoalTruck(List()))
      }
    }
  }
}
