package cpf.coalboss

import org.specs2.mutable.Specification
import org.specs2.matcher.MatchResult

class CoalBossSpec extends Specification {

  "coal boss" should {

    "load coal piles into trucks" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(5), CoalPile(4), CoalPile(3)))

      trucks must have size 2

      trucks.head.piles must have size 3
      truckMustContain(trucks.head, 5, 4, 0.9)

      trucks.last.piles must have size 1
      truckMustContain(trucks.last, 2.1)
    }

    "load coal piles into trucks when there are big piles" in {
      val trucks = CoalBoss.loadTrucks(List(CoalPile(15), CoalPile(14), CoalPile(13)))
      println(trucks)
      trucks must have size 5

      trucks.head.piles must have size 1
      truckMustContain(trucks.head, 9.9)

      trucks(1).piles must have size 2
      truckMustContain(trucks(1), 5.1, 4.8)

      trucks(2).piles must have size 2
      truckMustContain(trucks(2), 9.2, 0.7)

      trucks(3).piles must have size 1
      truckMustContain(trucks(3), 9.9)

      trucks.last.piles must have size 1
      truckMustContain(trucks.last, 2.4)
    }

  }

  private def truckMustContain(truck: CoalTruck, expectedWeights: Double*): Seq[MatchResult[Seq[Double]]] = {
    val weights = truck.piles.map(_.weight)
    expectedWeights.map(weight => weights must contain(beCloseTo(weight, 0.01)))
  }
}
