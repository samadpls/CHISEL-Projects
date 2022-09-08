package labs
import chisel3._
import org.scalatest._
import chiseltest._

class Countertest  extends FreeSpec with ChiselScalatestTester {
    "  SINT Test" in {
        test(new Count(3.S)){c=>
        c.clock.step(20)
        c.io.result.expect(0.B)

        }
    }
}