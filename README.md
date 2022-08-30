
# CHISEL

<p><em>Chisel</em> (Constructing
Hardware In a Scala Embedded Language) is a hardware
construction language embedded in the high-level programming language
Scala.
 Chisel is a library of special class
definitions, predefined objects, and usage conventions within <a href="https://www.scala-lang.org/">Scala</a>,
so when you write Chisel you are actually writing a Scala
program that constructs a hardware graph.
As you gain experience and want to make your code simpler or more
reusable, you will find it important to leverage the underlying power
of the Scala language. We recommend you consult one of the excellent
Scala books to become more expert in Scala programming.</p>
<p>For a tutorial covering both Chisel and Scala, see the 
<a href="https://mybinder.org/v2/gh/freechipsproject/chisel-bootcamp/master"><strong>online Chisel Bootcamp</strong></a>.</p>



# Verilog vs Chisel Side-By-Side

This page serves as a quick introduction to Chisel for those familiar with Verilog. It is by no means a comprehensive guide of everything Chisel can do. Feel free to file an issue with suggestions of things you'd like to see added to this page. 


<body>
    <!-- This script is needed so that Markdown and HTML will render together, see link to Stack overflow -->
      <table border="0">
        <h1>Creating a Module</h1>
        <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>
         <tr>
<td>

```verilog
module Foo (
  input  a,
  output b
);
  assign b = a;
endmodule
```

</td>
    <td>

```scala
class Foo extends Module {
  val a = IO(Input(Bool()))
  val b = IO(Output(Bool()))
  b := a
}
```
</td>
         </tr>
    </table>
</body>
</html>

<h1 id="parameterizing-a-module">Parameterizing a Module</h1>

<html>
<body>
    <table border="0">
          <tr>
            <td><b style="font-size:30px">Verilog</b></td>
            <td><b style="font-size:30px">Chisel</b></td>
         </tr>

<tr>
<td>

```verilog
module PassthroughGenerator(
  input  [width-1:0] in,
  output [width-1:0] out
);
 
  parameter width = 8;
  
  assign out = in;
endmodule
```
</td>
<td>

```scala
class PassthroughGenerator(width: Int = 8) extends Module {
    val in = IO(Input(UInt(width.W)))
    val out = IO(Output(UInt(width.W)))
    
    out := in
}
```
</td>
         </tr>
         <tr>
<td>

```verilog
module ParameterizedWidthAdder(
  input [in0Width-1:0] in0,
  input [in1Width-1:0] in1,
  output [sumWidth-1:0] sum
);
  parameter in0Width = 8;
  parameter in1Width = 1;
  parameter sumWidth = 9;

  assign sum = in0 + in1;

endmodule
```

</td>
<td>

```scala
class ParameterizedWidthAdder(
  in0Width: Int,
  in1Width: Int,
  sumWidth: Int) extends Module {
  
  val in0 = IO(Input(UInt(in0Width.W)))
  val in1 = IO(Input(UInt(in1Width.W)))
  val sum = IO(Output(UInt(sumWidth.W)))
  
  // a +&amp; b includes the carry, a + b does not
  sum := in0 +&amp; in1
}
```
</td>
</tr>
    </table>
 </body>
<html>

# END
