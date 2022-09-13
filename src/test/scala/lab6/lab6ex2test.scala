package labs
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class counter6test  extends FreeSpec with ChiselScalatestTester {
    "counter 6 Test" in {
        test(new counter6(5)){c=>
        c.clock.step(4)
        c.io.out.expect(4.U)


        }
    }
}