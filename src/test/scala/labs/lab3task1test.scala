package labs
import chisel3._
import org.scalatest._
import chiseltest._
class branchtest extends FreeSpec with ChiselScalatestTester{
    "Branch Test" in {
        test(new BranchControl()){c=>
        c.io.fnct3.poke(0.U)
        c.io.branch.poke(1.B)
        c.io.arg_x.poke(4.U)
        c.io.arg_y.poke(4.U)
        c.clock.step(1)
        c.io.br_taken.expect(1.B)

        }
    }
}