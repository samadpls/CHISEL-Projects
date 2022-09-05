package gates
import chisel3._
import org.scalatest._
import chiseltest._

class ANDtest  extends FreeSpec with ChiselScalatestTester {
    "AND Gate Test" in {
        test(new AND()){c=>
        c.io.a.poke(8.S)
        c.io.b.poke(15.S)
        c.clock.step(1)
        c.io.c.expect(-8.S)

        }
    }
}