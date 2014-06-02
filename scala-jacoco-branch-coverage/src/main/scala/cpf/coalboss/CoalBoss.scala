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
      if (!trucks.last.isFull) {
        loadAndKeepGoing(piles, trucks)
      } else {
        loadOneByOne(piles, trucks :+ CoalTruck(List()))
      }
    }
  }

  private def loadAndKeepGoing(piles: Seq[CoalPile], trucks: Seq[CoalTruck]): Seq[CoalTruck] = {
    val lastTruck = trucks.last
    val firstPile = piles.head

    if (lastTruck.spaceLeft == firstPile.weight) {
      lastTruck.load(firstPile)
      loadOneByOne(piles.tail, trucks :+ CoalTruck(List()))
    }
    else if (lastTruck.spaceLeft > firstPile.weight) {
      lastTruck.load(firstPile)
      loadOneByOne(piles.tail, trucks)
    }
    else {
      val (splitPile, remainingPile) = firstPile.split(lastTruck.spaceLeft)
      lastTruck.load(splitPile)

      loadOneByOne(remainingPile +: piles.tail, trucks :+ CoalTruck(List()))
    }
  }

}
