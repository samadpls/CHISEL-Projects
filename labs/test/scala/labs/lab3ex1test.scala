package labs
import chisel3._
import org.scalatest._
import chiseltest._

class encodertest  extends FreeSpec with ChiselScalatestTester {
    "Encoder Test" in {
        test(new Encoder4to2()){c=>
        c.io.in.poke(4.U)
        c.clock.step(20)
        c.io.out.expect(2.U)

        }
    }
}