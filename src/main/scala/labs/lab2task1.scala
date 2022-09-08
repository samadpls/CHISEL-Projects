package labs
import chisel3._
import chisel3.util._
class LM_IO_Interfacee extends Bundle {
    val s0 = Input ( Bool () )
    val s1 = Input ( Bool () )
    val s2 = Input ( Bool () )
    val out = Output ( UInt (32.W ) )
}
class Mux_5to1 extends Module {
val io = IO (new LM_IO_Interfacee )
// Start coding here
val conc = Cat(io.s2,io.s1,io.s0)


io.out := MuxCase ( false.B , Array (
( conc === 0.U) ->0.U ,
( conc === 1.U) ->8.U,
( conc === 2.U) ->16.U,
( conc === 3.U) ->24.U,
( conc === BitPat("b1??")) ->32.U
 )
)
}

// End your code here

