package chinchin;

public class Registers {

	
	public static String rs;
	public static String rt;
	public static String rd;
	public static String writeData;
	public static String readData1;
	public static String readData2;
	
	
	public static String[] file= {
			"0000000000001100",
			"0000000000001101",
			"0000000000001101",
			"0000000000001100",
			"0000000000001101",
			"0000000000001100",
			"0000000000001101",		
			"0000000000001100",
	
			"0000000000001101",
			"0000000000001100",
			"0000000000001101",
			"0000000000001100",
			"0000000000001101",
			"0000000000001100",
			"0000000000001101",
			"0000000000001100",
	}; 
	
	

	public static void Register(String rs2, String rt2,String rd2) {
		// TODO Auto-generated method stub
		if(ControlUnit.Jump==false) {
		 int intRs2=Integer.parseInt(rs2, 2);
		 int intRt2=Integer.parseInt(rt2, 2);
		 System.out.println("");
			System.out.println("register of rs is in position "+intRs2+" in register file");
			System.out.println("");
			System.out.println("register of rt is in position "+intRt2+" in register file");
		 readData1=file[intRs2];
		 readData2=file[4+intRt2];
		 System.out.println("");
			System.out.println("ReadData1 has address "+ readData1+" in register file that came from rs");
			 System.out.println("");
				System.out.println("ReadData2 has address "+ readData2+" in register file that came from rt");
		}
		else {
			 int intRs2=Integer.parseInt(rs2, 2);
			 System.out.println("");
				System.out.println("register of rs is in position "+intRs2+" in register file");
				 System.out.println("");

				 readData1=file[intRs2];
					System.out.println("ReadData1 has address "+ readData1+" in register file that came from rs");
					 System.out.println("");
		}
		 
	}
	
}
