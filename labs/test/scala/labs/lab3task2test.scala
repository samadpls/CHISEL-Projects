package labs
import chisel3._
import org.scalatest._
import chiseltest._
class immdetest extends FreeSpec with ChiselScalatestTester{
    "immediate Test" in {
        test(new ImmdValGen()){c=>
        c.io.instr.poke("b01010101011010101010101010010011".U)
        c.clock.step(1)
        c.io.immd_se.expect(1366.U)

        }
    }
}