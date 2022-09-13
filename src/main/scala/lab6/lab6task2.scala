package labs
import chisel3 . _
import chisel3 . util . _
class counter_with_xor ( val max : Int = 1) extends Module {
    val io = IO (new Bundle {
    val out = Output ( UInt (( log2Ceil ( max ) . W ) ) )
})
val count =RegInit(0.U(4.W))
io.out := count
when (count(3)^ max.B){
    count:= count+1.U
}.otherwise{
    count:= 0.U
}
    
// Start Coding here
}