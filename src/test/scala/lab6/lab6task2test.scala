package labs
import chisel3._
import org.scalatest._
import chiseltest._

class counterxor  extends FreeSpec with ChiselScalatestTester {
    "counter_with_xor Test" in {
        test(new counter_with_xor()){c=>
        c.clock.step(30)
         //c.io.out.expect(1.U)

        }
    }
}