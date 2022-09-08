package labs
import chisel3._
import org.scalatest._
import chiseltest._

class XORtest  extends FreeSpec with ChiselScalatestTester {
    "XOR Gate Test" in {
        test(new XOR()){c=>
        c.io.a.poke(8.S)
        c.io.b.poke(-15.S)
        c.clock.step(1)
        c.io.c.expect(-7.S)

        }
    }
}