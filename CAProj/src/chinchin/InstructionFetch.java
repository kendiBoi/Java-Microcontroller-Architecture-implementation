package chinchin;

import java.util.ArrayList;

public class InstructionFetch {
	//public static ArrayList<String> g1= new ArrayList<String>();
	
	public static String[] address = new String[16];
	
	
	//public static int iteration= 1;
	
		
	
	public static String[] InstFetch(int pc2) {
		System.out.println("Instruction Fetch Stage::");

		// TODO Auto-generated method stub
		String[] opcode = new String[4];
		
		
		for(int j=0; j< Memory.mem[pc2].length;j++) {
			address[j]=Memory.mem[pc2][j];
			System.out.print(address[j] +" ");
			
		}
		System.out.println();
		System.out.println();

		 ProgCount(pc2);

		return address;
	}
	public static void ProgCount(int pc) {
		// TODO Auto-generated method stub
	
		
		System.out.println(ControlUnit.Jump);
		if(Execute.ZeroFlag==true && ControlUnit.Branch==true ) {
			System.out.println("instruction from jumping is found");
			ControlUnit.pc=pc;
			//ControlUnit.pc++;
		}
		else if( ControlUnit.Jump==true) {
			System.out.println("instruction is found jumping is activated");
			ControlUnit.pc=pc;
			//ControlUnit.pc++;
		}
		else{
			ControlUnit.pc++;
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
