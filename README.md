# Java-Microcontroller-Architecture-implementation
Java simulation of the dataflow between CPU, Memory and data cache based on Von Neumann Architecture

micro-architecture of the memory is Von Neumann Architecture meaning both
the data and instruction memories are moduled into one encompassing module.

The size of the instruction memory and data memory comes from the size of the
memory which is 1024bits, the size of the memory is split in half and 512bits are
allocated to both instruction memory and data memory.

the number of registers is 16 and the size of each register is 16 bit.

the instruction format implemented is set 2 which has Arithmetic
Instructions(Add,Add immediate,Sub,Mult), Logical Instructions(Or,And
immediate,shift left logical,shift right logical), Data Transfer Instructions(load
word,store word), Conditional Branch Instructions(Branch on equal,Branch on
less then),Comparison Instructions( Set on less than immediate), Unconditional
Jump Instructions(Jump Register).

The type of cache is direct mapped cache and the replacement policy for reading
is that a cache block can only be placed in one specific location, determined by
cache block number, and the system address can be partitioned in the following
way. In this case, cache only stores the tag along with data of the whole cache
block,the replacement policy for Writing is that the cache will update cache on a
cache hit.

The PC is a Int variable that retrives the instruction from the instruction memory and
then the instruction is decoded into opcode,rs,rt,rd,shamt,immediate. it is then
transfered into control,control alu, register file and alu. control sets the signals for
all operations, alu control sets the kind of operation preformed, register file feeds
the alu its operands. the alu result is either passed to a mux or passed as an
address to data memory. data memory either saves the value or passes it to the
write data in the register file.
