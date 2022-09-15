package lab8
import chisel3._
import org.scalatest._
import chiseltest._

class memorytesting  extends FreeSpec with ChiselScalatestTester {
    "memoryassign Test" in {
        test(new memory_assignment()){c=>
        
        c.clock.step(10)
        c.io.memory_out(0).expect(0.U)
        c.io.memory_out(1).expect(0.U)
        c.io.memory_out(2).expect(0.U)
        c.io.memory_out(3).expect(0.U)
        // c.clock.step(10)
        c.io.requestor(0).valid.poke(1.B)
        c.io.requestor(0).bits.poke(12.U)
        c.io.requestor(1).valid.poke(0.B)
        c.io.requestor(1).bits.poke(12.U)
        c.io.requestor(2).valid.poke(0.B)
        c.io.requestor(2).bits.poke(10.U)
        c.io.requestor(3).valid.poke(0.B)
        c.io.requestor(3).bits.poke(12.U)
        c.io.Readaddr.poke(10.U)
        c.io.Writeaddr.poke(10.U)
        c.clock.step(10)
        }
    }
}
