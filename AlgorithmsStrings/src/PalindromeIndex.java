import java.util.Scanner;


public class PalindromeIndex {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T>0){
			String line = in.next().trim();
			
			int len = line.length();
			
			if(len%2 == 0){
				for(int i=0, j=len-1; i<j; i++){
					if(line.charAt(i) == line.charAt(j)){
						j--;
						if(i == j){
							System.out.println("-1");
							break;
						}
					}else if(line.charAt(i+1) == line.charAt(j)){
						System.out.println(i);
						break;
					}else{
						System.out.println(j);
						break;
					}
				}
			}else{
				for(int i=0, j=len-1; i<=j; i++){
					if(line.charAt(i) == line.charAt(j)){
						j--;
						if(i==j){
							System.out.println("-1");
							break;
						}
					}else if(line.charAt(i+1) == line.charAt(j) && line.charAt(j-1) == line.charAt(i)){
						if(line.charAt(i+2) == line.charAt(j-1)){
							System.out.println(i);
							break;
						}else{
							System.out.println(j);
							break;
						}
					}else if(line.charAt(i+1) == line.charAt(j)){
						System.out.println(i);
						break;
					}else{
						System.out.println(j);
						break;
					}
					
					if(i+1 == j){
						System.out.println("-1");
						break;
					}
				}
			}
			
			
			T--;
		}
	}

}
