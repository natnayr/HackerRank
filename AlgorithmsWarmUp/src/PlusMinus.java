import java.text.DecimalFormat;
import java.util.Scanner;


public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int pos=0,neg=0,zero=0;
		
		for(int i=0; i<t; i++){
			int num = in.nextInt();
			if(num == 0) zero ++;
			if(num < 0) neg ++;
			if(num > 0) pos ++;
		}
		
		double dt = t, dpos = pos, dneg = neg, dzero = zero;
		DecimalFormat df = new DecimalFormat("0.000");
		
		System.out.println(df.format(dpos/dt));
		System.out.println(df.format(dneg/dt));
		System.out.println(df.format(dzero/dt));

	}

}
