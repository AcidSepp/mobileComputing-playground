fun main() {
  val myJavaClass = MyJavaClass()
  val myKotlinClass = MyKotlinClass()

  IO.println(myJavaClass.javaClass.canonicalName)
  IO.println(myKotlinClass.javaClass.canonicalName)
}
