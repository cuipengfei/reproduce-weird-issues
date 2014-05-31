package cpf.coalboss

case class CoalTruck(var piles: Seq[CoalPile]) {
  val maxWeight = 9.9

  def isFull: Boolean = {
    occupiedSpace == maxWeight
  }

  def spaceLeft: Double = {
    maxWeight - occupiedSpace
  }

  def load(pile: CoalPile) = {
    piles = piles :+ pile
  }

  private def occupiedSpace: Double = {
    piles.map(_.weight).sum
  }
}
