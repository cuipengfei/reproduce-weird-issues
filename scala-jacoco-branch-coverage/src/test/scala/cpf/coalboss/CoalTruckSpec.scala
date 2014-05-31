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

  }

}
