package labs
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class Counter6btest  extends FreeSpec with ChiselScalatestTester {
    "counter 6b Test" in {
        test(new counter6b(13,4)){c=>
        c.clock.step(4)
        c.io.out.expect(8.U)


        }
    }
}