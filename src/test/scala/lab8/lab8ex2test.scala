package lab8
import chisel3._
import org.scalatest._
import chiseltest._

class lab8ex2test  extends FreeSpec with ChiselScalatestTester {
    "Forwarding Test" in {
        test(new Forwarding()){c=>
        c.io.enable.poke(1.B)
        c.io.rdAddr.poke(14.U )
        c.io.wrAddr.poke(14.U )
        c.io.wrData(0).poke(1.U)
        c.io.wrData(1).poke(1.U)
        c.io.mask(0).poke(0.B)
        c.io.mask(1).poke(0.B)
        c.io.wr_en.poke(1.B)
        c.clock.step(2)
        //c.io.dataOut().expect(3.U)
         //c.io.out.expect(1.U)

        }
    }
}
