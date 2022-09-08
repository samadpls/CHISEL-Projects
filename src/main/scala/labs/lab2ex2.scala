package labs
import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle {
    val in = Input ( UInt (8. W ) )
    val s0 = Input ( Bool () )
    val s1 = Input ( Bool () )
    val s2 = Input ( Bool () )
    val out = Output ( UInt () ) // UInt (1. W))
}
class Mux_8to1 extends Module {
    val io = IO (new LM_IO_Interface )
    val Mux4_to_1_a = Mux( io.s0 , MuxLookup( io.s0 , false.B,Array(
        (1.U)->io.in(3) ,
    (0.U)-> io.in(2) ) ),
    MuxLookup( io.s0 ,false.B,Array(
        (1.U)-> io.in (1) , 
        (0.U)->io.in (0) ) ))
    val Mux4_to_1_b = Mux( io.s1 , MuxLookup( io.s1 ,false.B, Array(
        (1.U)->io.in (7) ,
        (0.U)-> io.in (6) ) ),
    MuxLookup( io.s0 ,false.B, Array(
        (1.U)->io.in(5) ,
    (0.U)-> io.in (4) )) )
    val Mux2_to_1 = MuxLookup( io.s2 ,false.B,Array((1.U)-> Mux4_to_1_b ,(0.U)-> Mux4_to_1_a ))
    // Connecting output of 2 _to_1 Mux with the output port .
    io . out := Mux2_to_1
}