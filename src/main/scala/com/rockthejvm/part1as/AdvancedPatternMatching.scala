package com.rockthejvm.part1as

//noinspection TypeAnnotation,ScalaUnusedSymbol
object AdvancedPatternMatching {

  /*
    Pattern Matching:
    - constants
    - objects
    - wildcards
    - variables
    - infix patterns
    - lists
    - case classes
   */

  class Person(val name: String, val age: Int)

  object Person {
    def unapply(
        person: Person
    ): Option[(String, Int)] = // person match { case Person(string, int) => }
      if (person.age < 21) None
      else Some((person.name, person.age))

    def unapply(
        age: Int
    ): Option[String] = // int match { case Person(string) => ... }
      if (age < 21) Some("minor")
      else Some("legally allowed to drink")
  }

  val daniel = new Person("Daniel", 102)
  val danielPM = daniel match { // Person.unapply(daniel) => Option((n, a))
    case Person(n, a) => s"Hi there, I'm $n"
  }

  val danielLegalStatus = daniel.age match {
    case Person(status) => s"Daniel's legal drinking status is $status"
  }

  def main(args: Array[String]): Unit = {
    println(danielPM)
    println(danielLegalStatus)
  }
}
