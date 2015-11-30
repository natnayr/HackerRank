import java.util.Scanner;


public class CaesarCipher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String word = in.next();
		int moveBy = in.nextInt();
		
		
		for(int i=0; i<N; i++){
			char t = word.charAt(i);
			boolean isUpper = Character.isUpperCase(t);
			t = Character.toLowerCase(t);
			
			if(t >= 'a' && t <= 'z'){
				
				int transfer = (t - 'a' + moveBy) % 26;	
				char out = (char) (transfer + 'a');
				if(isUpper) out = Character.toUpperCase(out);
				System.out.print(out);
			}else{
				//just print out
				System.out.print(word.charAt(i));
			}
		}
	}
	
}
