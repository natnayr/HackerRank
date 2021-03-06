import java.util.Scanner;


public class TheTimeInWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] time = {
				"one","two","three","four","five","six","seven","eight","nine","ten",
				"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
				};
		
		
		Scanner in = new Scanner(System.in);
		int hh = in.nextInt();
		int mm = in.nextInt();
		int hour = 60;
		
		
		if(mm == 0){
			System.out.println(time[hh-1] + " o' clock");
		}else if(mm == 30){
			System.out.println("half past " + time[hh-1]);
		}else if(mm == 15){
			System.out.println("quarter past " + time[hh-1]);
		}else if(mm == 1){ 
			System.out.println(time[mm-1] + " minute past " + time[hh-1]);
		}else if(mm >= 2 && mm <= 20){
			System.out.println(time[mm-1] + " minutes past " + time[hh-1]);
		}else if(mm > 20 && mm < 30){
			System.out.println(time[20-1] + " " + time[(mm%10)-1] + " minutes past " + time[hh-1]);
		}else if(mm > 30 && mm < 60){
			if(hh == 12) hh = 0;
			mm = hour - mm;
			
			if(mm == 15){
				System.out.println("quarter to " + time[hh]);
			}else if(mm == 1){
				System.out.println(time[mm-1] + " minute to " + time[hh]);
			}else if(mm >= 2 && mm <= 20){
				System.out.println(time[mm-1] + " minutes to " + time[hh]);
			}else if(mm > 20 && mm < 30){
				System.out.println(time[20-1] + " " + time[(mm%10)-1] + " minutes to " + time[hh]);
			}
		}
	}

}
