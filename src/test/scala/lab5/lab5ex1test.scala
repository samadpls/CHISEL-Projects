package labs
import chisel3._
import org.scalatest._
import chiseltest._
class ALU5test extends FreeSpec with ChiselScalatestTester{
    "ALU5 Test" in {
        test(new ALUfive(16)){c=>
        c.io.alu_oper.poke(2.U)
        c.io.arg_x.poke(1.U)
        c.io.arg_y.poke(1.U)
        c.clock.step(1)
        c.io.alu_out.expect(2.U)

        }
    }
}
