package cpf.coalboss

object CoalBoss {
  def loadTrucks(piles: Seq[CoalPile]): Seq[CoalTruck] = {
    loadOneByOne(piles, List(CoalTruck(List())))
  }

  private def loadOneByOne(piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    if (piles.isEmpty) {
      trucks
    }
    else {
      val lastTruck = trucks.last
      val firstPile = piles.head

      if (!lastTruck.isFull) {
        if (lastTruck.spaceLeft == firstPile.weight) {
          loadCurrentTruckAndAddNewEmptyTruck(lastTruck, firstPile, piles, trucks)
        }
        else if (lastTruck.spaceLeft > firstPile.weight) {
          loadCurrentTruck(lastTruck, firstPile, piles, trucks)
        }
        else {
          splitLoadAndAddNewTruck(lastTruck, firstPile, piles, trucks)
        }
      } else {
        loadOneByOne(piles, trucks :+ CoalTruck(List()))
      }
    }
  }

  private def splitLoadAndAddNewTruck(lastTruck: CoalTruck, firstPile: CoalPile,
                                      piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    val (splitPile, remainingPile) = firstPile.split(lastTruck.spaceLeft)
    lastTruck.load(splitPile)

    loadOneByOne(piles.tail :+ remainingPile, trucks :+ CoalTruck(List()))
  }

  private def loadCurrentTruck(lastTruck: CoalTruck, firstPile: CoalPile,
                               piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    lastTruck.load(firstPile)
    loadOneByOne(piles.tail, trucks)
  }

  private def loadCurrentTruckAndAddNewEmptyTruck(lastTruck: CoalTruck, firstPile: CoalPile,
                                                  piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    lastTruck.load(firstPile)
    loadOneByOne(piles.tail, trucks :+ CoalTruck(List()))
  }
}
