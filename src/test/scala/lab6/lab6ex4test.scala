package labs
import chisel3._
import org.scalatest._
import chiseltest._

class Queuetest  extends FreeSpec with ChiselScalatestTester {
    "My_Queue Test" in {
        test(new My_Queue()){c=>
        c.io.in.bits.poke(1.U)
        c.io.in.valid.poke(1.B)
        c.io.out.ready.poke(1.B)
        c.clock.step(30)
        c.io.out.bits.expect(1.U)
         //c.io.out.expect(1.U)

        }
    }
}