package labs
import chisel3._
import org.scalatest._
import chiseltest._
class immdetest extends FreeSpec with ChiselScalatestTester{
    "immediate Test" in {
        test(new ImmdValGen()){c=>
        c.io.instr.poke("b0101010101101010101010100010011".U)
        c.clock.step(1)
        c.io.immd_se.expect(683.U)

        }
    }
}