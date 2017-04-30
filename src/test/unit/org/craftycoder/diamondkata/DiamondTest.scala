package org.craftycoder.diamondkata

import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table
import org.scalatest.{Matchers, WordSpec}

class DiamondTest extends WordSpec with Matchers {

  "a diamond" should {

    "have height proportional to the last letter" in {

      val samples = Table(
        ("letter", "height"),
        ('A', 1),
        ('B', 4),
        ('C', 5),
        ('D', 8)
      )

      forAll(samples) { (letter: Char, height: Int) =>
        Diamond.calculate(letter).lines.length shouldBe height
      }
    }


    "have width equal to height in all the lines" in {
      val samples = Table("letter", 'A', 'B', 'C', 'D')

      forAll(samples) { (letter: Char) =>
        val diamondLines = Diamond.calculate(letter).lines.toSeq
        val height: Int = diamondLines.size
        diamondLines.foreach { (line: String) =>
          line.length shouldBe height
        }

      }

    }

    "have lines in the correct format depending of the letter" in {

      Diamond.calculate('A').lines.toList(0) shouldBe "A"
      Diamond.calculate('B').lines.toList(1) shouldBe "B  B"


    }
  }

  def isSymmetrical(line: String): Boolean = line.reverse.mkString == line



}
