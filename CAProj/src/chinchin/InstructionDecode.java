package chinchin;

public class InstructionDecode {
	
	public static String immediate =new String("");
	public static String opcode =new String("");
	public static String shamt =new String("");
	public static void InstDecode(String[] inst){
		System.out.println("");
		System.out.println("Instruction Decode Stage::");
		System.out.println("");
		
		  String rs =new String("");
		  String rt =new String("");
		  String rd =new String("");
		  
		  
		 
		  
		  String opcodeStr =new String();
		  String[] opcode1 = new String[6];
	
		for(int j=0; j< 16;j++) {
			if(j<4) {
		opcode1[j]=inst[j];
		opcodeStr= opcodeStr + opcode1[j]; 
	}
		}
		System.out.println("Instruction is being fetched");
		ContUnit(opcodeStr);
		
		System.out.println();

		for(int j=0; j< inst.length;j++) {
			if(j<4) {
				opcode=opcode+ inst[j];
			
			}
			else if(j<7) {
				rs=rs+inst[j];
			}
			
			else if(j<10) {
				rt=rt+inst[j];
				}
			
			else if(ControlUnit.RegDst==true) {
			 if(j<13) {
				rd=rd+inst[j];
				immediate=immediate+inst[j];
			}
			else {
				shamt=shamt+inst[j];
				immediate=immediate+inst[j];
			}
			
			}
			
			else {
				
				immediate=immediate+inst[j];
			}
			
		}
		
		System.out.println("opcode is "+opcode);
		System.out.println("rs is "+rs);
		System.out.println("rt is "+rt);
		System.out.println("rd is "+rd);
		System.out.println("shamt is "+shamt);
		System.out.println("immediate is "+immediate);
		
		
		System.out.println();
		System.out.println("RegDst is set to "+ControlUnit.RegDst);
		System.out.println("Branch is set to "+ControlUnit.Branch);
		System.out.println("MemRead is set to "+ControlUnit.MemRead);
		System.out.println("MemtoReg is set to "+ControlUnit.MemToReg);
		System.out.println("ALUOp is set to "+ControlUnit.ALUOp);
		System.out.println("MemWrite is set to "+ControlUnit.MemWrite);
		System.out.println("ALUSrc is set to "+ControlUnit.ALUSrc);
		System.out.println("RegWrite is set to "+ControlUnit.RegWrite);
		
		System.out.println("immediate before sign extension "+immediate);
		SignExtend(immediate);
		System.out.println("immediate after sign extension "+immediate);

		Registers.rs=rs;
		Registers.rt=rt;
		Registers.rd=rd;
	}
	public static void SignExtend(String immediate1) {
		// TODO Auto-generated method stub
		 char LMBit= immediate1.charAt(0);
		 String strLMBit= new String();
		 strLMBit = strLMBit+LMBit;
		 String extend= new String();
			//System.out.println(LMBit);
		 for(int i=0; i<10;i++) {
			 extend=extend+strLMBit;
		 }
		// System.out.println(immediate);
		 immediate=extend+immediate;
		// System.out.println(immediate);
	}
	public static void ContUnit(String opcodeStr) {
		// TODO Auto-generated method stub
		switch(opcodeStr) {
		case "0000": 	System.out.println("Instruction is of Add");  ControlUnit.ALUOp="100"; ControlUnit.RegDst=true;ControlUnit.RegWrite=true; break;
		case "0010": 	System.out.println("Instruction is of sub");  ControlUnit.ALUOp="100"; ControlUnit.RegDst=true;ControlUnit.RegWrite=true; break;
		case "0011": 	System.out.println("Instruction is of multiply");  ControlUnit.ALUOp="100"; ControlUnit.RegDst=true;ControlUnit.RegWrite=true; break;
		case "0101": 	System.out.println("Instruction is of or");  ControlUnit.ALUOp="100"; ControlUnit.RegWrite=true;  ControlUnit.RegDst=true;break; 
		
		case "0001": 	System.out.println("Instruction is of add immediate");  ControlUnit.ALUOp="101";ControlUnit.RegWrite=true; ControlUnit.ALUSrc=true;break;
		case "0100": 	System.out.println("Instruction is of And immediate");  ControlUnit.ALUOp="101"; ControlUnit.RegWrite=true; ControlUnit.ALUSrc=true; break;
		case "1100":	System.out.println("instruction is slt immediate");  ControlUnit.ALUOp="101";ControlUnit.RegWrite=true; ControlUnit.ALUSrc=true; break;
		
		case "0110": 	System.out.println("Instruction is of shift left logical");  ControlUnit.ALUOp="001"; ControlUnit.RegWrite=true;  ControlUnit.RegDst=true;break;
		case "0111": 	System.out.println("Instruction is of shift right logical");  ControlUnit.ALUOp="001"; ControlUnit.RegWrite=true;  ControlUnit.RegDst=true;break; 
		
		case "1000":	System.out.println("instruction is loadWord");  ControlUnit.ALUOp="000";ControlUnit.MemRead=true;ControlUnit.MemToReg=true;ControlUnit.ALUSrc=true; break;
		case "1001":	System.out.println("instruction is storeWord");ControlUnit.ALUOp="000"; ControlUnit.MemWrite=true; ControlUnit.ALUSrc=true;break;
		
		case "1010":	System.out.println("instruction is beq");  ControlUnit.ALUOp="010"; ControlUnit.Branch=true;  break;
		case "1011":	System.out.println("instruction is bgt");  ControlUnit.ALUOp="010"; ControlUnit.Branch=true;  break;
		
		case "1101":	System.out.println("instruction is Jump Register");  ControlUnit.Jump=true;  break;


		default :System.out.print("Register ZERO has a constant value of Zero.") ;
		}
		
			}

}
