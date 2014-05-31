package cpf.coalboss

import org.specs2.mutable.Specification

class CoalPileSpec extends Specification {

  "Coal pile" should {

    "split itself into two piles" in {
      val pile = CoalPile(5)
      val (splitPile, remainingPile) = pile.split(3)

      splitPile.weight === 3
      remainingPile.weight === 2
    }

  }

}
