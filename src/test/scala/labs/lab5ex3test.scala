package labs
import chisel3._
import org.scalatest._
import chiseltest._
class Operatortest extends FreeSpec with ChiselScalatestTester{
    "operator test Test" in {
        test(new Operator(2 , UInt(16.W ))(_+_)){c=>
        c.io.in(0).poke(2.U)
        c.io.in(1).poke(2.U)
        c.clock.step(1)
        c.io.out(0).expect(4.U)
        c.io.out(1).expect(4.U)
        }
    }
}
