package gates
import chisel3._
import org.scalatest._
import chiseltest._

class Encoder  extends FreeSpec with ChiselScalatestTester {
    "Encoder Test" in {
        test(new mux_onehot_4to1()){c=>
        c.io.sel.poke(2.U)
        c.clock.step(30)
        c.io.out.expect(1.U)

        }
    }
}