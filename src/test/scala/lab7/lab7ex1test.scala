package lab7
import chisel3._
import org.scalatest._
import chiseltest._

class ex1test  extends FreeSpec with ChiselScalatestTester {
    "Ex1 Test" in {
        test(new ex1()){c=>
        c.io.in1.bits.poke(1.U)
        c.io.in1.valid.poke(1.B)
        c.io.in2.bits.poke(1.U)
        c.io.in2.valid.poke(1.B)
        c.io.out.ready.poke(1.B)
        c.clock.step(30)
        c.io.out.bits.expect(1.U)
         //c.io.out.expect(1.U)

        }
    }
}