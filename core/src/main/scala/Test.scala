object Test {

  @getParamNames
  def ttt(v: String, v2: Int): Unit = {
    println("!!!" + v)
  }

  @getParamNames
  def oneMoreMethod(v: String, v2: Int, oneMoreParam: String): Unit = {
    println("!!!" + v)
  }

  def main(args: Array[String]): Unit = {
    println("The generated variable with list of parameter names: " + this.tttParams)
    println("The generated variable with list of parameter names: " + this.oneMoreMethodParams)
  }

}