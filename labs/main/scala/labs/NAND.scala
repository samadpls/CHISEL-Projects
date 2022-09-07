package labs
import chisel3._

class NAND extends Module{
    val io=IO(new Bundle{
        val a=Input(SInt(4.W))
        val b=Input(SInt(4.W))
        val c=Output(SInt(4.W))

})
io.c:= ~(io.a & io.b)
}