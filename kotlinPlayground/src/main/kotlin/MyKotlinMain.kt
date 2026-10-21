import kotlin.math.sqrt

open class Animal {

  var name: String = "Mautzi"
    get() {
      println("GEETTTTTT")
      return field
    }
    set(value) {
      println("seeeeettt")
      field = value
    }

  open fun shout() {
    println("HUUUUUUU")
  }

}

class Hund : Animal() {

  override fun shout() {
    println("UHHHHHHH")

  }

}

class Square(var width: Float) {

  var area: Float
    get() = width * width
    set(value) {
      width = sqrt(value)
    }

}


fun main() {

  val animal = Hund()

  animal.shout()
}
