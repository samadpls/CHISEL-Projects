package gates
import chisel3._
import org.scalatest._
import chiseltest._

class ORtest  extends FreeSpec with ChiselScalatestTester {
    "OR Gate Test" in {
        test(new OR()){c=>
        c.io.a.poke(1.S)
        c.io.b.poke(15.S)
        c.clock.step(1)
        c.io.c.expect(15.U)

        }
    }
}