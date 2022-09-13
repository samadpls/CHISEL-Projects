package labs
import chisel3._
import chisel3.util._
class LM_IO_Interface_BranchControl extends Bundle {
    val fnct3 = Input ( UInt (3.W ) )
    val branch = Input ( Bool () )
    val arg_x = Input ( UInt (32.W ) )
    val arg_y = Input ( UInt (32.W ) )
    val br_taken = Output ( Bool () )
}
class BranchControl extends Module {
    val io = IO (new LM_IO_Interface_BranchControl )
    var xy=Wire(Bool())
    xy:=0.B
// Start Coding here
switch(io.fnct3){
    is("b000".U){xy:=io.arg_x === io.arg_y} //equal
    is("b001".U){xy:=io.arg_x =/= io.arg_y} //not equal
    is("b100".U){xy:=io.arg_x<io.arg_y} //lesser equal
    is("b101".U){xy:=io.arg_x>io.arg_y }// greater equal
    is("b110".U){xy:=io.arg_x<=io.arg_y} //lesser than unsign
    is("b111".U){xy:=io.arg_x>=io.arg_y} //greater than unsign
}
io.br_taken:=xy && io.branch
// End your code here
// Well , you can actually write classes too . So , technically you have no limit ; )
}