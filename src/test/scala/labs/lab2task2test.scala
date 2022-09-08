package labs
import chisel3._
import org.scalatest._
import chiseltest._

class mux4bit  extends FreeSpec with ChiselScalatestTester {
    "mux 4 bit Test" in {
        test(new barrel_shift()){c=>
        c.io.in(0).poke(0.B)
        c.io.in(1).poke(1.B)
        c.io.in(2).poke(1.B)
        c.io.in(3).poke(0.B) 
        c.io.sel(0).poke(0.B)
        c.io.sel(1).poke(0.B)
        c.io.shift_type.poke(0.B)
        c.clock.step(20)
        c.io.out(0).expect(0.B)
        c.io.out(1).expect(1.B)
        c.io.out(2).expect(1.B)
        c.io.out(3).expect(0.B)

        }
    }
}