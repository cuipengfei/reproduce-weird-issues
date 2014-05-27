package cpf.branch.coverage

class Biz {

  def doBiz(inputMsg: String): String = {
    delegateService(inputMsg) match {
      case OKResult(result) => result.toString
      case FailureResult(error) => error
    }
  }

  private def delegateService(msg: String): Result = {
    if (msg.length > 5) OKResult("message length ok")
    else FailureResult("message too short")
  }
}
