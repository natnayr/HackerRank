import java.util.Scanner;


public class SherlockAndValidString {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int[] alphaCount = new int[26];
		String word = in.next();
		
		for(int i=0; i<word.length(); i++){
			alphaCount[word.charAt(i)-97]++;
		}
		
		int element=0,remove=0, diff=0;
		for(int i=0; i<alphaCount.length; i++){
			if(alphaCount[i] == 0){
				continue;
			}
			
			if(element == 0){
				element = alphaCount[i];
			}
			
			if((element - alphaCount[i]) != 0){
				
				if(diff !=0 && )
					
				remove++;
				if(remove>1){
					System.out.println("NO");
					System.exit(0);
				}
				
				element = alphaCount[i];
				
				if(Math.abs(element - alphaCount[i]) > 1){
					//quick death
					remove+=5;
				}
			}
			
			
			
			
		}
	}

}
