package gates
import chisel3._
import chisel3.util._

class barrel_shift extends Module {
    val io = IO (new Bundle {
    val in = Vec (4 , Input ( Bool () ) )
    val sel = Vec (2 , Input ( Bool () ) )
    val shift_type = Input ( Bool () )
    val out = Vec (4 , Output ( Bool () ) )
})
 val pin=Cat(io.sel(1),io.sel(0))
 
    io.out(0):=MuxLookup(pin,false.B,Array(
        (0.U)-> io.in(0), 
        (1.U)-> io.in(1),
        (2.U)-> io.in(2),
        (3.U)-> io.in(3),
    ))
    
    io.out(1):=MuxLookup(pin,false.B,Array(
        (0.U)-> io.in(1), 
        (1.U)-> io.in(2),
        (2.U)-> io.in(3),
        (3.U)-> Mux(io.shift_type,io.in(0),0.U)))
        
    io.out(2):=MuxLookup(pin,false.B,Array(
        (0.U)-> io.in(2), 
        (1.U)-> io.in(3),
        (2.U)-> Mux(io.shift_type,io.in(0),0.U) , 
        (3.U)->  Mux(io.shift_type,io.in(1),0.U) ))
       
    io.out(3):=MuxLookup(pin,false.B,Array(
        (0.U)-> io.in(3), 
        (1.U)->Mux(io.shift_type,io.in(0),0.U) ,
        (2.U)-> Mux(io.shift_type,io.in(1),0.U) ,
        (3.U)->  Mux(io.shift_type,io.in(2),0.U) ) ) 
       
}
// End your code here

