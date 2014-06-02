package cpf.coalboss

import org.specs2.mutable.Specification
import org.specs2.matcher.MatchResult

class CoalBossSpec extends Specification {

  "coal boss" should {

    "load coal piles into trucks" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(5), CoalPile(4), CoalPile(3)))

      trucks.size === 2

      trucks.head.piles must have size 3
      truckMustContain(trucks.head, 5, 4, 0.9)

      trucks.last.piles.size === 1
      truckMustContain(trucks.last, 2.1)
    }

  }

  private def truckMustContain(truck: CoalTruck, expectedWeights: Double*): Seq[MatchResult[Seq[Double]]] = {
    val weights = truck.piles.map(_.weight)
    expectedWeights.map(weight => weights must contain(beCloseTo(weight, 0.01)))
  }
}
