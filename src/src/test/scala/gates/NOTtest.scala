package gates
import chisel3._
import org.scalatest._
import chiseltest._

class NOTtest  extends FreeSpec with ChiselScalatestTester {
    "NOT Gate Test" in {
        test(new NOT()){c=>
        c.io.a.poke(8.S)
        c.clock.step(1)
        c.io.c.expect(7.S)

        }
    }
}