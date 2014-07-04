package cpf.branch.coverage

import org.specs2.mutable.Specification

class BizSpec extends Specification {
  "biz" should {
    "work fine" in {
      new Biz().doBiz(OKResult("whatever")) === "whatever"
    }

    "fail" in {
      new Biz().doBiz(FailureResult("oops")) === "oops"
    }

    "fail when no match" in {
      new Biz().doBiz(null) must throwA[MatchError]
    }
  }
}
