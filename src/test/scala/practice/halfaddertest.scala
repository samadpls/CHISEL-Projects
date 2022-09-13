package labs
import chisel3._
import org.scalatest._
import chiseltest._

class halfaddertest  extends FreeSpec with ChiselScalatestTester {
    "halfadder Gate Test" in {
        test(new halfadder()){c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.sum.expect(-7.S)
        c.io.cout.expect(0.S)

        }
    }
}