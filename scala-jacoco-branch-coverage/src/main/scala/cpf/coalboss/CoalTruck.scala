package cpf.coalboss

case class CoalTruck(piles: Seq[CoalPile]) {
  val maxWeight = 9.9

  def isFull: Boolean = {
    occupiedSpace == maxWeight
  }

  def spaceLeft: Double = {
    maxWeight - occupiedSpace
  }

  def load(pile: CoalPile): CoalTruck = {
    CoalTruck(piles :+ pile)
  }

  private def occupiedSpace: Double = {
    piles.map(_.weight).sum
  }
}
