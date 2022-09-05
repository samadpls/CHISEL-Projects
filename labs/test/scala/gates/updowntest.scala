package gates
import chisel3._
import org.scalatest._
import chiseltest._

class updowntest  extends FreeSpec with ChiselScalatestTester {
    "  updown Test" in {
        test(new counter_up_down(3)){c=>
        c.clock.step(40)

        }
    }
}