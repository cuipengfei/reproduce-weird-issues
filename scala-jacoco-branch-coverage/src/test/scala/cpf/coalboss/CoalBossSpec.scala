package cpf.coalboss

import org.specs2.mutable.Specification
import org.specs2.matcher.MatchResult

class CoalBossSpec extends Specification {

  "coal boss" should {

    "load coal piles into trucks" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(5), CoalPile(4), CoalPile(3)))

      trucks must have size 2

      truckMustContain(trucks.head, 5, 4, 0.9)
      truckMustContain(trucks.last, 2.1)
    }

    "load coal piles into trucks when there are big piles" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(15), CoalPile(14), CoalPile(13)))

      trucks must have size 5

      truckMustContain(trucks.head, 9.9)
      truckMustContain(trucks(1), 5.1, 4.8)
      truckMustContain(trucks(2), 9.2, 0.7)
      truckMustContain(trucks(3), 9.9)
      truckMustContain(trucks.last, 2.4)
    }

  }

  private def truckMustContain(truck: CoalTruck, expectedWeights: Double*): Seq[MatchResult[Any]] = {
    val weights = truck.piles.map(_.weight)
    (weights.size === truck.piles.size) +:
      expectedWeights.map(weight => weights must contain(beCloseTo(weight, 0.01)))
  }
}
