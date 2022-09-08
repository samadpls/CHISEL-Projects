package labs
import chisel3._
import chisel3.util._
class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32.W ) )
    val immd_se = Output ( UInt (32.W ) )
}
class ImmdValGen extends Module {
    val io = IO (new LM_IO_Interface_ImmdValGen )
// Start coding here

    val opcode =io.instr(6,0)
    io.immd_se:=0.U
    switch(opcode){
        is("b0010011".U){io.immd_se:=Cat(Fill(20,io.instr(31)),io.instr(31,20))}//i-type
        is("b0100011".U){io.immd_se:=Cat(Fill(20,io.instr(31)),io.instr(31,25),io.instr(11,7))} //s type
        is("b1100011".U){io.immd_se:=Cat(Fill(19,io.instr(31)),io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),0.U)} // sb type
        is("b0110111".U){io.immd_se:=Cat(Fill(12,io.instr(31)),io.instr(31,12))} // u type
        is("b1101111".U){io.immd_se:=Cat(Fill(11,io.instr(31)),io.instr(31),io.instr(19,12),io.instr(20),io.instr(31,21),0.U)} //uj type
    }
// End your code here
// Well , you can actually write classes too . So , technically you have nolimit ; )
}
