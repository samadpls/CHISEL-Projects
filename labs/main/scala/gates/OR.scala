package gates
import chisel3._

class OR() extends Module{
    val io=IO(new Bundle{
        val a=Input(SInt(4.W))
        val b=Input(SInt(4.W))
        val c=Output(UInt(4.W))

})
    io.c:= io.a.asUInt | io.b.asUInt
}