package org.craftycoder.diamondkata

object Diamond {

  def calculate(lastLetter: Char): String = {

    val top: Seq[String] = for (letter <- 'A' to lastLetter) yield toLine(lastLetter)

    val diamond =
      if (isOdd(index(lastLetter) + 1)) top ++ top.drop(1)
      else top ++ top

    diamond.mkString("\n")
  }

  private def toLine(lastLetter: Char): String = {

    val totalLen =
      if (isOdd(index(lastLetter) + 1)) index(lastLetter) * 2 + 1
      else (index(lastLetter) + 1) * 2

    " " * totalLen
  }


  private def index(letter: Int): Int = letter - 'A'

  private def isOdd(n: Int): Boolean = n % 2 == 1

}
