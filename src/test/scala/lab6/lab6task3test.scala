// package labs
// import chisel3._
// import chisel3.util._

// import org.scalatest._
// import chiseltest._

// class shiftreg1  extends FreeSpec with ChiselScalatestTester {
//     "shift_reg_with_parallel_load Test" in {
//         test(new shift_reg_with_parallel_load()){c=>
//         io.out(0).expect(1.B)
//         io.out(1).expect(0.B)
//         io.load_in(0).poke(1.B)
//         io.load_in(1).poke(0.B)
//         io.in.poke(0.B)
//         io.load.poke(0.B)
//         c.clock.step(30)
        
//          //c.io.out.expect(1.U)

//         }
//     }
// }