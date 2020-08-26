package chinchin;

public class WriteBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void WriteBack(String aLUresult, String ReadData, boolean memToReg, boolean regDst) {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("Write Back Stage::");
		System.out.println("");
		if(memToReg==false) {
			Registers.writeData=Execute.ALUresult;
			
			System.out.println(" Write data is written to with alu output Data : "+Registers.writeData);
		}
		else if(memToReg==true) {
			Registers.writeData=ReadData;
			System.out.println(" Write data is written to with memory read Data : "+Registers.writeData);
		}
		else {
		System.out.println("Instruction does not write back");
		}
		if(regDst==true) {
			int reg=Integer.parseInt(Registers.rd,2);
			Registers.file[reg]=Registers.writeData;
			System.out.println("Destination Register(rd) "+Registers.rd+" has data: "+Registers.file[reg]);
		}
		else {
			int reg=Integer.parseInt(Registers.rt,2);
			Registers.file[reg]=Registers.writeData;
			System.out.println("Destination Register(rt) "+Registers.rt+" has data: "+Registers.file[reg]);
		}
		
	}

}
