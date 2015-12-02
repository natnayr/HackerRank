import java.util.Scanner;


public class PalindromeIndex2 {

	public static void main(String[] main){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T>0){
			
			String line = in.next();
			int len = line.length();
			int i, j;
			
			for(i=0, j=len-1; i<(len/2) && i<j; j--,i++)
				if(line.charAt(i) != line.charAt(j)) 
					break;
			
			//if i is middle item in odd length, print middle item
			if(i == (len/2)){
				if((len%2) == 1){
					System.out.println(len/2);
					continue;
				}
			}
			
			//check if left side is the index
			int x,y;
			for(x=i+1,y=j; x<y; x++,y--){
				if(line.charAt(x) != line.charAt(y)){
					break;
				}
			}
			if(x>=y){
				System.out.println(i);
			}else{
				
				//if the index is not on the left, check right
				for(x=i,y=j-1; x<y; x++,y--){
					if(line.charAt(x) != line.charAt(y)){
						break;
					}
				}
				
				if(x>=y){
					System.out.println(j);
				}else{
					System.out.println("-1");
				}
			}
			
			
			
			T--;
		}
	}
	
}
