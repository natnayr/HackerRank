import java.util.Scanner;


public class AlternatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			String line = in.next();
			int deletions = 0;
			char curChar = line.charAt(0);
			for(int i=1; i<line.length(); i++){
				if(line.charAt(i) == curChar){
					deletions++;
				}else{
					curChar = line.charAt(i);
				}
			}
			
			System.out.println(deletions);
		}
	}

}
