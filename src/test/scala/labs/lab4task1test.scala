package labs
import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.util._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import ALUOP._

class Testbranch extends FreeSpec with ChiselScalatestTester{
    "Branch Test" in {
        test(new BranchControl()){ c =>
         val array_op = Array ( 0,1,4,5,6,7)
         
    for ( i <- 0 until 100) {
        val src_a = Random.nextLong () & 0xFFFFFFFFL
        val src_b = Random.nextLong () & 0xFFFFFFFFL
        val opr = Random.nextInt (6)
        val branch= Random.nextBoolean()
        val funct3 = array_op ( opr )
        println(funct3)
        val result = funct3 match {
            case 0 => if (src_a === src_b) 1 else 0
            case 1 => if (src_a != src_b) 1 else 0
            case 4 => if (src_a < src_b) 1 else 0
            case 5 => if (src_a > src_b) 1 else 0
            case 6 => if (src_a <= src_b) 1 else 0
            case 7 => if (src_a>= src_b) 1 else 0
            case _ => 0
        }

        c.io.fnct3.poke(funct3.U)
        c.io.branch.poke(branch.B)
        c.io.arg_x.poke(src_a.U)
        c.io.arg_y.poke(src_b.U)
        c.clock.step(1)
        println(branch, result)
        if (branch=== true){
        c.io.br_taken.expect(result.B)}
        else {
        c.io.br_taken.expect(0.B)}
            }
        c.clock.step (2)
        }
    }
}
