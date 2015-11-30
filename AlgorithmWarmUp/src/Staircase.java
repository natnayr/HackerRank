import java.util.Scanner;


public class Staircase {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int space = t;
		int hash = 1;
		
		while(space > 0){
			
			for(int i=0; i<space-1; i++) System.out.print(" ");
			for(int i=0; i<hash; i++) System.out.print("#");
			System.out.println();
			hash++;
			space--;
		}
		
	}

}
