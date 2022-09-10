package labs
import chisel3._
import org.scalatest._
import chiseltest._
class Adder5test extends FreeSpec with ChiselScalatestTester{
    "Adder5 Test" in {
        test(new Adder5(32)){c=>
        c.io.in0.poke(2.U)
        c.io.in1.poke(2.U)
        c.clock.step(1)
        c.io.sum.expect(4.U)

        }
    }
}
