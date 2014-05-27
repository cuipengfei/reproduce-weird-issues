package cpf.branch.coverage

class Biz {

  def doBiz(inputMsg: String): Result = {
    delegateService(inputMsg)
  }

  def delegateService(msg: String): Result = {
    if (msg.length > 5) OKResult("message length ok")
    else FailureResult("message too short")
  }
}
