package labs
import chisel3._
import chisel3.util._
class My_Queue extends Module {
    val io = IO (new Bundle {
    val in = Flipped(Decoupled(UInt(8.W))) //ready-> output , valid->input
    val out = Decoupled(UInt(8.W)) // ready-> input, valid->output
    })

// your code begin
    val q1=Queue(io.in,5)
    val q2=Queue(q1,5)
    q2.ready:=0.B
    when (q2.valid===1.B && io.out.ready===1.B){
        io.out.enq(io.in.deq())
    }.otherwise{
        io.out.valid:=0.B
        io.out.bits:=0.U
        
    }
}