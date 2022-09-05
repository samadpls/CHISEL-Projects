package gates
import chisel3._
import org.scalatest._
import chiseltest._

class muxtest extends FreeSpec with ChiselScalatestTester{
    "MUX tester" in {
        test(new mux()){c=>
        c.io.a.poke(4.U)
        c.io.b.poke(1.U)
        c.io.sel.poke(3.U)
        c.clock.step(1)
        c.io.x.expect(5.U)

        }
    }
}