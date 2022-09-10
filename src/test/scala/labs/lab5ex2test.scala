package labs
import chisel3._
import org.scalatest._
import chiseltest._
class eMuxTest extends FreeSpec with ChiselScalatestTester{
    "Emux test Test" in {
        test(new eMux(UInt(32.W))){c=>
        c.io.in1.poke(2.U)
        c.io.in2.poke(1.U)
        c.io.sel.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(2.U)

        }
    }
}
