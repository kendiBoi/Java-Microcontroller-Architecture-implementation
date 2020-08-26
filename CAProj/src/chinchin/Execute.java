package chinchin;

public class Execute {
//	 ALUresult (32-bits) , ZeroFlag (1-bit), BranchAddressResult (32-bits), ReadData2 (32-bits), PC incremented by 4. (32-bits).
public static String ALUresult= new String();
public static boolean ZeroFlag= false;
public static String BranchAddressResult= new String();
public static String ExcuteReadData1= new String();
public static String ExcuteReadData2= new String();
public static String StrOutput= new String();

public static void ALUEvaluator(String Op, String Operand3 , String Operand4,String shamt) {
		int z=0;
		 int Operand1=Integer.parseInt(Operand3, 2); 
		 int Operand2=Integer.parseInt(Operand4,2);
		int output=0;
		int intShamt=0;
		if(Op.equals("1001")|Op.equals("0110")) {
			intShamt= Integer.parseInt(shamt, 2);
		}
		String operation = new String();
		
		String StrBranch= new String();
		String StrImmeadiate=InstructionDecode.immediate;
		String StrAddreas=new String();	
		
		for(int i =0;i<InstructionFetch.address.length;i++) {
			StrAddreas=StrAddreas+InstructionFetch.address[i];
		}
	
		System.out.println("addreass in execute stage : "+StrAddreas);
		
		
		if(Op.equals("0010")) {
			operation="and";
			 output =(Operand1 & Operand2);	
		}
		else if(Op.equals("0011")) {
			operation="or";
			output=(Operand1 | Operand2);
		}
		else if(Op.equals("0000")) {
			operation="add";
			output=(Operand1 + Operand2);
		}
		else if(Op.equals("0001")) {
			operation="sub";
			output=(Operand1 - Operand2);
		}
		else if(Op.equals("0100")) {
			operation="slt";
			if(Operand1<Operand2) {
			output=Operand1;
			}
		}
			else if(Op.equals("1000")) {
				operation="mult";
				output=(Operand1 * Operand2);
			}
			else if(Op.equals("1111")) {
				operation="s$0gt";
				if(Operand1>Operand2) {
					output=0;
				}
			}
			else if(Op.equals("1001")) {
				operation="sll";
				output=(Operand1<<intShamt);
			}
			else if(Op.equals("0110")) {
				operation="srl";
				output=(Operand1>>intShamt);
			}
			else {
				operation="unknown";
				output =0;
			}
		
		
		if(output==0) {
			z=1;
			ZeroFlag=true;
		}
		
		Operand3=Integer.toString(Operand1,2);
		Operand4=Integer.toString(Operand2,2);
		StrOutput=Integer.toString(output,2);
		
	
		
		ALUresult=StrOutput;
		int j = 16-ALUresult.length();
		 for(int i=0; i<j;i++) {
			 ALUresult="0"+ALUresult;
		 	}
		 
		 ExcuteReadData1=Operand3;
		 j= 16-ExcuteReadData1.length();
		 	for(int i=0;i<j;i++) {
					 ExcuteReadData1="0"+ExcuteReadData1; 
				 }
				 
		 ExcuteReadData2=Operand4;
		 j=16-ExcuteReadData2.length(); 
		 	for(int i=0;i<j;i++) {
					 ExcuteReadData2="0"+ExcuteReadData2;
				 }
				 
		System.out.println();
		System.out.println();
		System.out.println("Operation Name: " +operation);
		System.out.println("1st Operand: " + ExcuteReadData1);
		System.out.println("2nd Operand: "+ ExcuteReadData2);
		System.out.println("Output: "+ ALUresult);
		System.out.println("Z-Flag Value: "+z+" "+ZeroFlag);
	
		if(z==1&&ControlUnit.Branch==true && ZeroFlag==true) {
			int IntImmeadiate=Integer.parseInt(StrImmeadiate,2);;
			int IntAddreas =Integer.parseInt(StrAddreas,2);
			int IntBranch=IntImmeadiate+IntAddreas;
			StrBranch=Integer.toString(IntBranch,2);
			
			BranchAddressResult=StrBranch;
			
			 j=16-BranchAddressResult.length(); 
			 for(int i=0; i<j;i++) {
				 BranchAddressResult="0"+BranchAddressResult;
			 }
				System.out.println("Branch Address Result: "+ BranchAddressResult);
		}

	}

	public static void Execute(String opcode,String aLUOp, boolean aLUSrc, String rs, String rt, String immediate, String shamt) {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("Instruction Exucution Stage::");
		System.out.println("");
		
		System.out.println("opcode: "+opcode);
		System.out.println("aluOp: "+aLUOp);
		System.out.println("aluSrc: "+aLUSrc);
		System.out.println("rs: "+rs);
		System.out.println("rt: "+rt);
		System.out.println("immediate: "+immediate);

		
		
		//lw/sw
		if(aLUOp.equals("000") && ControlUnit.ALUSrc==true) {
			System.out.println("reached");

			ALUEvaluator("0000",rs,immediate, shamt);
		}
		//branch
		else if(aLUOp.equals("010") && ControlUnit.ALUSrc==false) {
			switch(opcode) {
			case "1010":ALUEvaluator("0001",rs,rt, shamt);break;//beq
			case "1011":ALUEvaluator("1111",rs,rt, shamt);break;//bgt
			}
		}
		//R-format
		else if(aLUOp.equals("100") && ControlUnit.ALUSrc==false) {
			System.out.println();
			System.out.println(opcode);
			
			 switch(opcode) {
			 case "0000": ALUEvaluator("0000",rs,rt, shamt);break;//add
			 case "0010": ALUEvaluator("0001",rs,rt, shamt);break;//sub
			 case "0011": ALUEvaluator("1000",rs,rt, shamt);break;//multi
			 case "0101": ALUEvaluator("0011",rs,rt, shamt);break;//or
			 }
		/*	 Registers.rd=StrOutput;
			 System.out.println(ALUresult);
			 System.out.println("Register rd has data: "+Registers.rd);
			 */
		}
		//R-format immediate
		else if(aLUOp.equals("101") && ControlUnit.ALUSrc==true) {
			System.out.println();
			System.out.println(opcode);
			 System.out.println("this is "+rs+"  "+immediate);
			 switch(opcode) {
		//	 System.out.println("this is "+rs+"  "+immediate);
			 
			 case "0001": ALUEvaluator("0000",rs,immediate, shamt);break;//add immediate
			 case "0100": ALUEvaluator("0010",rs,immediate, shamt);break;//and immediate
			 case "1100": ALUEvaluator("0100",rs,immediate, shamt);break;//slt immediate
			 }
				/*	 Registers.rd=StrOutput;
			 System.out.println(ALUresult);
			 System.out.println("Register rd has data: "+Registers.rd);
			 */
		}
		//Branch
		else if(aLUOp.equals("001") && ControlUnit.ALUSrc==false) {
			switch(opcode) {
			case "0110": ALUEvaluator("1001",rs,rt, shamt);break;//sll
			case "0111": ALUEvaluator("0110",rs,rt, shamt);break;//srl
			}
		}
		
	} 
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
