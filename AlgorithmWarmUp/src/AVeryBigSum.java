import java.math.BigInteger;
import java.util.Scanner;


public class AVeryBigSum {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();
    	BigInteger arr[] = new BigInteger[t];
    	
    	BigInteger sum = BigInteger.valueOf(0);
    	for(int i=0; i<t; i++){
    		arr[i] = in.nextBigInteger();
    	}
    	
    	for(int i=0; i<arr.length; i++){
    		sum = sum.add(arr[i]);
    	}
    	
    	System.out.println(sum.toString());

	}

}
