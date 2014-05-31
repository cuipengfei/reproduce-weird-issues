package cpf.coalboss

case class CoalPile(weight: Double) {
  def split(splitWeight: Double): (CoalPile, CoalPile) = {
    (CoalPile(splitWeight), CoalPile(weight - splitWeight))
  }
}
