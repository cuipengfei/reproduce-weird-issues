package cpf.branch.coverage

trait Result

case class OKResult(successMsg: String) extends Result

case class FailureResult(errorMsg: String) extends Result