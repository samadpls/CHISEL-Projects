package gates
import chisel3._
import chisel3.util._
class mux_onehot_4to1 extends Module {
val io = IO (new Bundle {
val sel = Input ( UInt (4.W ) )
val out = Output ( UInt (2.W ) )
})
val in1=0.U
val in2=1.U
val in3=2.U
val in4=3.U
io.out := Mux1H( io.sel , Seq(in1,in2,in3,in4) )

}