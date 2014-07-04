package cpf.branch.coverage

class Biz {

  def doBiz(result: Result): String = {
    result match {
      case OKResult(msg) => msg
      case FailureResult(msg) => msg
    }
  }

}
