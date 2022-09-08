package labs
import chisel3._
import org.scalatest._
import chiseltest._

class resettest  extends FreeSpec with ChiselScalatestTester {
    "Reset Test" in {
        test(new resetcounter(5)){c=>
        c.clock.step(20)
        c.io.result.expect(0.B)

        }
    }
}