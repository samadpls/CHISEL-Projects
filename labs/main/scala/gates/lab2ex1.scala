package gates
import chisel3._
import chisel3.util._
// Mux IO interface class
class Mux_2to1_IO extends Bundle {
val in_A = Input ( UInt (32.W ) )
val in_B = Input ( UInt (32.W ) )
val select = Input ( Bool () )
val out = Output ( UInt (32.W) )
}

class Mux_2to1 extends Module {
val io = IO (new Mux_2to1_IO )
val copy  = Fill(32,io.select.asUInt)
// update the output
io.out:=io.in_A & (~copy)  | io.in_B &  copy
}
// when(io.out===1.U){
//     io.out:=io.in_A

// }otherwise{
//     io.out:=io.in_B
// }