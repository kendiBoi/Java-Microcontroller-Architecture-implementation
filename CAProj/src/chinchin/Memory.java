package chinchin;

public class Memory {
	public static String[][] mem = new String[64][16];//1024bit

public static int ic=0;	
public static int dc=32;
public static String ReadData=new String();
public static String WriteData=new String();

	
			
	public static void insertData(String string) {
		// TODO Auto-generated method stub
		if(dc<64) {
		for(int i=0;i<16;i++) {
			String helper= new String(); 
			helper=helper+string.charAt(i);
			mem[dc][i]=	helper;
			//System.out.print(mem[dc][i]);			
		}
		//Cache.dataCache(mem[dc]);
		dc++;
		}
	}
	public static void insertInst(String string) {
		// TODO Auto-generated method stub
		if(ic<32) {
		for(int i=0;i<16;i++) {
			String helper= new String(); 
			helper=helper+string.charAt(i);
			mem[ic][i]=	helper;
			//System.out.print(mem[ic][i]);			
		}
		//Cache.instCache(mem[ic]);
		ic++;
		}
	}
	public static void Read(String aLUresult) {
		// TODO Auto-generated method stub
		for(int i=32;i<dc;i++) {
	
			
							String search=new String("");
							for(int j=0;j<16;j++) {
								search=search+mem[i][j];
							}
							System.out.println(search);
							if(aLUresult.equals(search)) {
								System.out.println("data is inserted and can be found in data memory");
								ReadData=aLUresult;
							}
							else {System.out.println("data cannot be found in data memory");}
					}
		
		
	}
	
}


