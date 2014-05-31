package cpf.coalboss

import org.specs2.mutable.Specification

class CoalTruckSpec extends Specification {

  "Coal truck" should {

    "tell if it is full" in {
      val fullTruck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3.9)))
      fullTruck.isFull === true
    }

    "tell if it is not full" in {
      val notFullTruck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3)))
      notFullTruck.isFull === false
    }

    "tell how much space is left" in {
      val truck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3)))
      truck.spaceLeft must beCloseTo(0.9, 0.01)
    }

    "load pile" in {
      val truck = CoalTruck(List(CoalPile(5), CoalPile(1), CoalPile(3)))
      val truckAfterLoad = truck.load(CoalPile(0.5))

      truckAfterLoad.spaceLeft must beCloseTo(0.4, 0.01)
      truckAfterLoad.piles.last.weight === 0.5
    }

  }

}
