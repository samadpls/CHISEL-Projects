package lab8
import chisel3._ 
import chisel3.util._ 

class ex3 extends Module{
    val io=IO(new Bundle{
        val writein=Input(Bool())
        val addr=Input(UInt(32.W))
        val data_in=Input(UInt(32.W))
        val data_out=Output(UInt(32.W))
    })
    val mem=Mem(32,UInt(32.W))
    when(io.writein){
        mem.write(io.addr,io.data_in)
    }
    io.data_out:=mem.read(io.addr)
}