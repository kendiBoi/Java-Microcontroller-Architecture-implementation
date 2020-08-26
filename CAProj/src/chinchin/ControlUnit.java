package chinchin;

public class ControlUnit {
	public static int pc =0;
	public static boolean RegDst= false;
	public static boolean RegWrite= false;
	public static boolean ALUSrc= false;
	public static boolean PCSrc= false;
	public static boolean MemRead=false ;
	public static boolean MemToReg= false;
	public static boolean MemWrite= false;
	public static String ALUOp;
	public static boolean Branch= false;
	public static boolean Jump=false;
	
	

	
		
	public static void run() {
	
		
		
		while(pc<Memory.ic) {
		//	boolean RegDst= false;boolean RegWrite= false;boolean ALUSrc= false;boolean PCSrc= false; boolean MemRead=false ; boolean MemToReg= false; boolean MemWrite= false;	String ALUOp; boolean Branch= false;
			
			InstructionDecode.InstDecode(InstructionFetch.InstFetch(pc));	
			System.out.println();
			Registers.Register(Registers.rs,Registers.rt,Registers.rd);
			System.out.println();
			if(Jump==false) {
			Execute.Execute(InstructionDecode.opcode,ALUOp,ALUSrc,Registers.readData1,Registers.readData2,InstructionDecode.immediate,InstructionDecode.shamt);
			System.out.println();
			MemoryAccess.MemAccess(Execute.ALUresult,Execute.ExcuteReadData2,InstructionDecode.immediate,Execute.ZeroFlag, Execute.BranchAddressResult , MemWrite , MemRead, Branch); 
			System.out.println();
			WriteBack.WriteBack(Execute.ALUresult,Memory.ReadData,MemToReg,RegDst);
			}
			else {
				MemoryAccess.jump(Registers.readData1);
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println();
			reset();

			

		}
	}

	
	public static void reset() {
		// TODO Auto-generated method stub
		RegDst= false;
		RegWrite= false;
		ALUSrc= false;
		PCSrc= false;
		MemRead=false ;
		MemToReg= false;
		MemWrite= false;
		ALUOp=new String();
		Branch= false;
		Jump = false;
		InstructionDecode.immediate=new String();
		Execute.ALUresult= new String();
		Execute.ZeroFlag= false;
		Execute.BranchAddressResult= new String();
		Execute.ExcuteReadData2= new String();
		Execute.ExcuteReadData1= new String();
		InstructionDecode.opcode= new String();
		InstructionDecode.shamt=new String();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Memory.insertInst("0000111010001000");//add
		Memory.insertInst("0010111001010000");//sub
		Memory.insertInst("0011111001010000");//multiply
		Memory.insertInst("0101111001010000");//or
		
		Memory.insertInst("1001111001010000");//sw
		Memory.insertInst("1000111001010000");//lw
		
		Memory.insertInst("0001111010001000");//addi
		Memory.insertInst("0100111001010000");//andi		
		Memory.insertInst("1100111001010000");//slti
		
		Memory.insertInst("0110111001010010");//sll
		Memory.insertInst("0111111001010010");//srl
		
		Memory.insertInst("1010001001010000");//beq
		Memory.insertInst("1011111001010000");//bgt
		
		
		
		Memory.insertInst("1101111001010000");//jr
	//for testing jump 
	//	Memory.insertInst("0011111001010000");//multiply
	//	Memory.insertInst("0101111001010000");//or
		
		Memory.insertInst("0000000000001100");//jump address

		ControlUnit.run();









	//	ControlUnit.run();
	}
}
