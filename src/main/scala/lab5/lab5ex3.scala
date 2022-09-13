package labs
import chisel3._
import chisel3.util._
// class definition with function as parameter
class Operator [ T <: Data ]( n : Int , generic : T )( op :(T , T ) =>T ) extends Module {
    require ( n > 0) // " reduce only works on non - empty Vecs "
    val io = IO (new Bundle {
    val in = Input ( Vec (n , generic ) )
    val out = Output (Vec(n, generic ))
    })

  for (i<-0 until n){
    print(i)
    io.out(i):=io.in.reduce(op)
  }
}