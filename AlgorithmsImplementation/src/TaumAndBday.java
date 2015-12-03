import java.util.Scanner;


public class TaumAndBday {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long T = in.nextLong();
		while(T > 0){
			
			long numB = in.nextLong();
			long numW = in.nextLong();
			long X = in.nextLong();
			long Y = in.nextLong();
			long Z = in.nextLong();
			
			long justB = numB * X;
			long transB = (numB * Y) + (numB * Z);
			long costB = Math.min(justB, transB);
			
			long justW = numW * Y;
			long transW = (numW * X) + (numW * Z);
			long costW = Math.min(justW, transW);
			
			System.out.println(costB + costW);
			
			T--;
		}
	}
	
}
