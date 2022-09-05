package gates
import chisel3._
import org.scalatest._
import chiseltest._

class mux2test  extends FreeSpec with ChiselScalatestTester {
    "mux2 Test" in {
        test(new Mux_2to1()){c=>
        c.io.in_A.poke(10.U)
        c.io.in_B.poke(11.U)
        c.io.select.poke(0.B)
        c.clock.step(20)
        c.io.out.expect(10.B)

        }
    }
}