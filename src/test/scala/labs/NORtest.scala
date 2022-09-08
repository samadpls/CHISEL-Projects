package labs
import chisel3._
import org.scalatest._
import chiseltest._

class NORtest  extends FreeSpec with ChiselScalatestTester {
    "NOR Gate Test" in {
        test(new NOR()){c=>
        c.io.a.poke(8.S)
        c.io.b.poke(15.S)
        c.clock.step(1)
        c.io.c.expect(0.S)

        }
    }
}