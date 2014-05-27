package cpf.branch.coverage

import org.specs2.mutable.Specification

class BizSpec extends Specification {
  "biz" should {
    "work fine when message longer than 5" in {
      new Biz().doBiz("123456") === "message length ok"
    }

    "fail when message is 5 chars or less" in {
      new Biz().doBiz("12345") === "message too short"
    }
  }
}
