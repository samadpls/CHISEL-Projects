package gates
import chisel3._
class resetcounter(n:Int) extends Module{
    val io=IO(new Bundle{
    val result=Output(Bool())
    })
    val max=((math.pow(2, n).toInt)-(math.pow(2, n-1).toInt)).asUInt
    val count=RegInit(0.U(n.W))
    dontTouch(count)
    when (count===max){

        count:=0.U
    }.otherwise{
        count:=count+1.U
    }
    io.result:=count(4.U)
}
