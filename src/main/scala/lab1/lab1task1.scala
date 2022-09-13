package labs
import chisel3._
 
class mux extends Module{
    val io=IO(new Bundle{
        val a=Input(UInt(4.W))
        val b=Input(UInt(4.W))
        val sel=Input(UInt(3.W))
        val x=Output(UInt(4.W))

    })
    when(io.sel===0.U){
        io.x:=io.a + io.b
    }.elsewhen(io.sel===1.U){
        io.x:=io.a - io.b
    }.elsewhen(io.sel===2.U){
        io.x:=io.a & io.b
    }.elsewhen(io.sel===3.U){
        io.x:=io.a | io.b
    }.elsewhen(io.sel===4.U){
        io.x:=io.a ^ io.b
    }.elsewhen(io.sel===5.U){
        io.x:= ~(io.a ^ io.b)
    }.otherwise{
        io.x:=0.U
    }
}