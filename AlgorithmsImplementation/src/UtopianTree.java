import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			
			int val = 1;
			int n = in.nextInt();
			
			for(int i=0; i<n; i++){
				if((i%2) == 1){
					val++;
				}else if((i%2) == 0){
					val *= 2;
				}
			}
			System.out.println(val);
			
			T--;
		}
		
	}

}
