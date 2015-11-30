import java.util.Scanner;


public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while(T > 0){
			
			String inRead = in.next();
			long fullNum = Long.parseLong(inRead);
			
			int count = 0;
			
			for(int i=0; i<inRead.length(); i++){
				long divisor = Long.parseLong(inRead.substring(i, i+1));
				if(divisor > 0){
					if((fullNum%divisor) == 0){
						count++;
					}
				}
			}
			
			System.out.println(count);
			T--;
		}
	}

}
