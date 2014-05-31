package cpf.coalboss

import org.specs2.mutable.Specification

class CoalTruckSpec extends Specification {

  "Coal truck" should {

    "tell if it is full" in {
      val fullTruck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3.9)))
      fullTruck.isFull === true
    }

    "tell if it is not full" in {
      val fullTruck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3)))
      fullTruck.isFull === false
    }

    "tell how much space is left" in {
      val fullTruck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3)))
      fullTruck.spaceLeft must beCloseTo(0.9, 0.01)
    }

  }

}
