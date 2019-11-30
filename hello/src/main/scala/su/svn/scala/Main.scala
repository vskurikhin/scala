package su.svn.scala

object Main {
  private def filter(args: Array[String]) = {
    args filter (_ startsWith "-") map (" " + _.drop(1))
  }

  def main(args: Array[String]): Unit = {
    println("Добро пожаловать.")
    val x = CubeCalculator.cube(3)
    println("x = " + x)
    val person = new Person()
    println("person = " + person)
    println("Выбраны опции: " +: filter(args) mkString "\n")
  }
}
