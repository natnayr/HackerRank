import java.util.Scanner;


public class TheLoveLetterMystery {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			
			String line = in.next();
			int len = line.length();
			
			int moveCount = 0;
			for(int i=0,j=len-1; i<j && i<len/2; i++,j--){
				moveCount += (Math.abs(line.charAt(i) - line.charAt(j)));
			}
			
			System.out.println(moveCount);
		}
	}

}	
