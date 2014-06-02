package cpf.coalboss

import org.specs2.mutable.Specification
import org.specs2.matcher.MatchResult
import org.specs2.ScalaCheck
import org.scalacheck.Gen
import org.scalacheck.Prop

class CoalBossSpec extends Specification with ScalaCheck {

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

  val pileGenerator = for {
    weight <- Gen.choose(0.0, 20.0)
  } yield CoalPile(weight)
  val pilesGenerator = Gen.containerOf[List, CoalPile](pileGenerator)

  "n-1 trucks should be full and one may not be full" ! Prop.forAll(pilesGenerator) {

    (piles: List[CoalPile]) => val trucks = CoalBoss.loadTrucks(piles)
      val firstNMinusOneTrucks = trucks.dropRight(1)

      println("---start testing property---")
      println(piles)
      println(trucks)
      println("---end testing property---")
      //ScalaCheck generates 100 test cases for us
      //each test case has some random piles

      firstNMinusOneTrucks.foreach(truck => truck.spaceLeft must beCloseTo(0, 0.01))

      trucks.last.spaceLeft must beLessThanOrEqualTo(9.9)
  }

  private def truckMustContain(truck: CoalTruck, expectedWeights: Double*): Seq[MatchResult[Any]] = {
    val weights = truck.piles.map(_.weight)
    (weights.size === truck.piles.size) +:
      expectedWeights.map(weight => weights must contain(beCloseTo(weight, 0.01)))
  }
}
