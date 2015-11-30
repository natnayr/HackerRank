import java.util.Scanner;


public class FunnyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			
			String message = in.next();
			String reverse = new StringBuilder(message).reverse().toString();
			
			boolean funny = true;
			for(int i=1; i<message.length(); i++){
				if(Math.abs(message.charAt(i) - message.charAt(i-1)) != Math.abs(reverse.charAt(i) - reverse.charAt(i-1))){
					funny = false;
				}
			}
			
			if(funny == true){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
			
			T--;
		}
	}

}
