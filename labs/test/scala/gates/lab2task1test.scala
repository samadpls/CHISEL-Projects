package gates
import chisel3._
import org.scalatest._
import chiseltest._

class mux5  extends FreeSpec with ChiselScalatestTester {
    "Mux5-1 Test" in {
        test(new Mux_5to1()){c=>
        c.io.s0.poke(1.B)
        c.io.s1.poke(1.B)
        c.io.s2.poke(1.B)
        c.clock.step(30)
        c.io.out.expect(32.U)

        }
    }
}