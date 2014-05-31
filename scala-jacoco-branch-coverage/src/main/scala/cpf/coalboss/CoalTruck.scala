package cpf.coalboss

case class CoalTruck(piles: Seq[CoalPile]) {
  val maxWeight = 9.9

  def isFull: Boolean = {
    piles.map(_.weight).sum == maxWeight
  }
}
