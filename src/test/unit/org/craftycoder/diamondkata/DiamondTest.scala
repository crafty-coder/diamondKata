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
        println(s"$letter -> $height")
        diamondLines.foreach { (line: String) =>
          println(s"$letter -> $line")
          line.length shouldBe height
        }

      }

    }
  }
}
