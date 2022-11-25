package com.rockthejvm.part1as

import scala.annotation.tailrec

//noinspection TypeAnnotation,ScalaUnusedSymbol
object Recap {

  // values, types, expressions
  val aCondition = false // vals are constants
  val anIfExpression = if (aCondition) 42 else 55 // expressions evaluated to a value

  // types: Int, String, Double, Boolean, Char, ...
  // Unit = () == "void" in other languages

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack & tail
  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc
    else factorial(n - 1, n * acc)

  val fact10 = factorial(10, 1)

  // object oriented programming
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog

  trait Carnivore {
    infix def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override infix def eat(a: Animal): Unit = println("I'm a croc, I eat everything")
  }

  // methods notation
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // "operator"/infix position

  // anonymous classes
  val aCarnivore = new Carnivore {
    override infix def eat(a: Animal): Unit = println("I'm a carnivore")
  }

  // generics
  abstract class LList[A] {
    // type A is known inside the implementation
  }
  // singletons and companions
  object LList // companion object, used for instance-independent ("static") fields/methods

  // case class


  def main(args: Array[String]): Unit = {

  }
}
