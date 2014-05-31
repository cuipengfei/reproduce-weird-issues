package cpf.coalboss

case class CoalTruck(piles: Seq[CoalPile]) {
  val maxWeight = 9.9

  def isFull: Boolean = {
    occupiedSpace == maxWeight
  }

  def spaceLeft: Double = {
    maxWeight - occupiedSpace
  }

  private def occupiedSpace: Double = {
    piles.map(_.weight).sum
  }
}
