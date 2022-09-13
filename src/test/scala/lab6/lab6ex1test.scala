package labs
import chisel3._
import org.scalatest._
import chiseltest._

class Ptest extends FreeSpec with ChiselScalatestTester{
    "Parallel tester" in {
        test(new shift_register()){c=>
        c.io.in.poke(4.U)
        c.clock.step(10)
        c.io.out.expect(0.U)

        }
    }
}