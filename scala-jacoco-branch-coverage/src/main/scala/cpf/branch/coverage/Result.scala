package cpf.branch.coverage

trait Result

case class OKResult[A](a: A) extends Result

case class FailureResult(msg: String) extends Result