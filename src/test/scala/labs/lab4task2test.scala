package labs
import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.util._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import ALUOP._

class TestImmed extends FreeSpec with ChiselScalatestTester{
    "Immediate Test" in {
        test(new ImmdValGen()){ c =>
         val array_op =  Array("b0101010101101010101010100010011","b0101010101101010101010100100011", "b0101010101101010101010101100011","b0101010101101010101010100110111","b0101010101101010101010101101111")
         
    for ( i <- 0 until 100) {
        val opr = Random.nextInt (5)
        val imm = array_op ( opr )
        val result = imm match {
          case("b0101010101101010101010100010011") => 683
          case("b0101010101101010101010100100011") => 682
          case("b0101010101101010101010101100011") => 682
          case("b0101010101101010101010100110111") => 174933
          case("b0101010101101010101010101101111") => 701098
        }

       c.io.instr.poke(imm.U)
        c.clock.step(1)
        c.io.immd_se.expect(result.U)
            }
        c.clock.step (2)
        }
    }
}
