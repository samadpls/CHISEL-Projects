package lab8
import chisel3._
import chisel3.util._
class memory_assignment extends Module {
    val io = IO (new Bundle {
    val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
    val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
    val Readaddr = Input ( UInt (5. W ) )
    val Writeaddr = Input ( UInt (5. W ) )
})
// Start your code from here
    val q1 = Queue(io.requestor(0))
    val q2 = Queue(io.requestor(1))
    val q3 = Queue(io.requestor(2))
    val q4 = Queue(io.requestor(3))
    val arb = Module (new Arbiter ( UInt () ,4 ) )
    arb . io . in (0) <> q1
    arb . io . in (1) <> q2
    arb . io . in (2) <> q3
    arb . io . in (3) <> q4
    arb.io.out.ready:=1.B
    val mem = SyncReadMem (1024 , Vec (4 , UInt ( 32 . W ) ) )
    val temp= Reg(Vec(4,UInt(32.W)))
    when(io.requestor(3).valid){
        temp(3):=arb.io.out.bits
        temp(2):=0.U
        temp(1):=0.U
        temp(0):=0.U
    }.elsewhen(io.requestor(2).valid){
        temp(3):=0.U
        temp(2):=arb.io.out.bits
        temp(1):=0.U
        temp(0):=0.U
        
    }.elsewhen(io.requestor(1).valid){
        temp(3):=0.U
        temp(2):=0.U
        temp(1):=arb.io.out.bits
        temp(0):=0.U
        
    }.elsewhen(io.requestor(0).valid){
        temp(3):=0.U
        temp(2):=0.U
        temp(1):=0.U
        temp(0):=arb.io.out.bits
        
        
    }
    
    mem.write(io.Writeaddr,temp)
    io.memory_out:=mem.read(io.Readaddr)

// End your code here
}
//     io.in1.ready:=0.B
//     io.in2.ready:=0.B

//     val q1= Queue(io.in1,4)
//     val q2= Queue(io.in2,4)
//     val arb = Module (new RRArbiter ( UInt () , 2) )
// // connect the inputs to different producers
//     arb_noPriority . io . in (0) <> q1
//     arb_noPriority . io . in (1) <> q2
//     io.out <> arb_noPriority.io.out
// }