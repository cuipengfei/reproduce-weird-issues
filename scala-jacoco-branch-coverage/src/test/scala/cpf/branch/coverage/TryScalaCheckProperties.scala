package cpf.branch.coverage

import org.specs2.mutable.Specification
import org.specs2.ScalaCheck

class TryScalaCheckProperties extends Specification with ScalaCheck {
  "addition and multiplication are related" ! prop {
    (a: Double) => a + a == 4 * a / 2
    //this property will fail after a few tries
    //because of the double precision
  }
}
