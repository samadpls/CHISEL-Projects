package labs
import chisel3._
import org.scalatest._
import chiseltest._
class ALUtest extends FreeSpec with ChiselScalatestTester{
    "ALU Test" in {
        test(new ALU()){c=>
        c.io.in_A.poke(4.U)
        c.io.in_B.poke(5.U)
        c.io.alu_Op.poke(4.U)
        c.clock.step(40)
        c.io.out.expect(1.U)
        c.io.sum.expect(9.U)

        }
    }
}