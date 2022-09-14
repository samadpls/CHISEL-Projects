package lab7
import chisel3._
import chisel3.util._
class ex1 extends Module {
    val io = IO (new Bundle {
    val in1 = Flipped(Decoupled(UInt(8.W))) //ready-> output , valid->input
    val in2 = Flipped(Decoupled(UInt(8.W))) //ready-> output , valid->input
    val out = Decoupled(UInt(8.W)) // ready-> input, valid->output
    })
    io.in1.ready:=0.B
    io.in2.ready:=0.B

    val q1= Queue(io.in1,4)
    val q2= Queue(io.in2,4)
    val arb_noPriority = Module (new RRArbiter ( UInt () , 2) )
// connect the inputs to different producers
    arb_noPriority . io . in (0) <> q1
    arb_noPriority . io . in (1) <> q2
    io.out <> arb_noPriority.io.out
}