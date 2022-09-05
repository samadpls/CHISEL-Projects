package gates
import chisel3._
import org.scalatest._
import chiseltest._

class mux3test  extends FreeSpec with ChiselScalatestTester {
    "mux3 Test" in {
        test(new Mux_8to1()){c=>
        c.io.in.poke(5.U)
        c.io.s0.poke(1.B)
        c.io.s1.poke(0.B)
        c.io.s2.poke(0.B)
        c.clock.step(30)
        c.io.out.expect(0.U)

        }
    }
}