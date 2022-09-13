package labs
import chisel3._
import org.scalatest._
import chiseltest._

class Decodervalid  extends FreeSpec with ChiselScalatestTester {
    "Decoder with valid Test" in {
        test(new decoder_with_valid()){c=>
        c.io.in.poke(1.U)
        c.clock.step(20)
        c.io.out.bits.expect(2.U)
        c.io.out.valid.expect(1.B)

        }
    }
}