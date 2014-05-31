package cpf.coalboss

import org.specs2.mutable.Specification

class CoalBossSpec extends Specification {

  "coal boss" should {

    "load coal piles into trucks" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(5), CoalPile(4), CoalPile(3)))

      trucks.size === 2

      trucks.head.piles.size === 3
      trucks.head.piles.head.weight must beCloseTo(5, 0.01)
      trucks.head.piles(1).weight must beCloseTo(4, 0.01)
      trucks.head.piles.last.weight must beCloseTo(0.9, 0.01)

      trucks.last.piles.size === 1
      trucks.last.piles.head.weight must beCloseTo(2.1, 0.01)
    }

  }

}
