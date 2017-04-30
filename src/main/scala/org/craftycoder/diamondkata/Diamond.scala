package org.craftycoder.diamondkata

object Diamond {

  def calculate(lastLetter: Char): String = {

    val top: Seq[String] = for (letter <- 'A' to lastLetter) yield toLine(lastLetter,letter)

    val diamond =
      if (isOdd(index(lastLetter) + 1)) top ++ top.reverse.drop(1)
      else top ++ top

    diamond.mkString("\n")
  }

  private def toLine(maxLetter: Char, letter: Char): String = {
    val letterIndex = index(maxLetter) - index(letter)
    val halfLine = " "*letterIndex + letter + " "*(index(maxLetter)-letterIndex)

    halfLine ++ halfLine.reverse.tail
  }


  private def index(letter: Int): Int = letter - 'A'

  private def isOdd(n: Int): Boolean = n % 2 == 1

}
