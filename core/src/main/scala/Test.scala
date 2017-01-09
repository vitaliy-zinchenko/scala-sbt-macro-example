object Test extends App {

  @getParamNames
  def ttt(v: String, v2: Int): Unit = {
    println("!!!" + v)
  }

  println("The generated variable with list of parameter names: " + this.tttParams)

  @getParamNames
  def oneMoreMethod(v: String, v2: Int, oneMoreParam: String): Unit = {
    println("!!!" + v)
  }

  println("The generated variable with list of parameter names: " + this.oneMoreMethodParams)

}