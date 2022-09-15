package lab8
import chisel3._ 
import org.scalatest._ 
import chiseltest._ 

class ex3test extends FreeSpec with ChiselScalatestTester{
    "Read Write Instruction" in {
        test (new ex3()){c=>
        c.io.writein.poke(1.B)
        c.io.addr.poke(2.U)
        c.io.data_in.poke(11.U)
        c.clock.step(1)
        c.io.data_out.expect(11.U)

        }
    }
}