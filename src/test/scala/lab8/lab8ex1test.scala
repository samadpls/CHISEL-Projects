package lab8
import chisel3._
import org.scalatest._
import chiseltest._

class lab8ex1test  extends FreeSpec with ChiselScalatestTester {
    "MaskedReadWriteSmem Test" in {
        test(new MaskedReadWriteSmem()){c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(14.U )
        c.io.mask(0).poke(0.B)
        c.io.mask(1).poke(0.B)
        c.io.mask(2).poke(0.B)
        c.io.mask(3).poke(0.B)
        c.io.dataIn(0).poke(1.U)
        c.io.dataIn(1).poke(1.U)
        c.io.dataIn(2).poke(1.U)
        c.io.dataIn(3).poke(1.U)
        c.clock.step(2)
        //c.io.dataOut().expect(3.U)
         //c.io.out.expect(1.U)

        }
    }
}