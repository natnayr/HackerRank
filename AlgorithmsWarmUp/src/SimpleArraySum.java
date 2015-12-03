import java.util.Scanner;



public class SimpleArraySum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();
    	int arr[] = new int[t];
    	
    	int sum = 0 ;
    	for(int i=0; i<t; i++){
    		arr[i] = in.nextInt();
    	}
    	
    	for(int i=0; i<arr.length; i++){
    		sum += arr[i];
    	}
    	
    	System.out.println(sum);
    }
}