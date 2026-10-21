fun myFirstHigherOrderFunction(myFun: (String, String) -> Int): Int {
  return myFun(
    "a",
    "b"
  )
}



fun main() {

  val myFirstHigherOrderFunction =
    myFirstHigherOrderFunction { a: String, b: String -> a.length + b.length }

  println(myFirstHigherOrderFunction)

}
