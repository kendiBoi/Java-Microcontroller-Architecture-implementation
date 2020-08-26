package chinchin;

public class Cache {
	
	public static boolean[] validBitblock = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	public static int[] tagblock= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	public static int[] indexblock={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	public static String[] datablock= {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null"};
	
	public static void writeDataCache(String address) {
		System.out.println("");
		System.out.println("Cache Write Stage::");
		System.out.println("");
		int intAddress= Integer.parseInt(address, 2);
		int index = intAddress%16;
		int tag= intAddress/16;
		// TODO Auto-generated method stub
		System.out.println("address of the data in cache "+address);
		System.out.println(intAddress);
		System.out.println("index of the address "+index);
		System.out.println("tag of the address"+tag);
	
		datablock[index] = address;
		tagblock[index] = tag;
		validBitblock[index] = true;
		indexblock[index] = index;
		System.out.println("Cache Stage Done continuing Memory Access Stage::");
	}
	public static void readDataCache(String address) {
		System.out.println("");
		System.out.println("Cache Read Stage::");
		System.out.println("");
		int intAddress= Integer.parseInt(address, 2);
		int index = intAddress%16;
		int tag =intAddress/16;
	
		if(validBitblock[index]){
			if(tag == tagblock[index]){
				System.out.println("Hit! found data in cache!");
			}
			else{
				System.out.println("Miss! could not find the data in cache!");
				writeDataCache(address);
				validBitblock[index] = true;
			}
		}else {
			System.out.println("Miss! could not find the data in cache!");
			writeDataCache(address);
		}
		System.out.println("Cache Stage Done continuing Memory Access Stage::");
	}
	
	public static void main(String[] args) {
		
	}

	

}
