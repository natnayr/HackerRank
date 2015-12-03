import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String timmer = in.nextLine().trim();
		boolean pm = false;
		if(timmer.substring(8, 10).equals("PM")){
			pm = true;
		}
		
		int hh = Integer.parseInt(timmer.substring(0, 2));
		if(pm == true && hh != 12){
			hh += 12;
		}
		if(hh == 12 && pm == false){
			hh = 0;
		}
		
		if(hh < 10) System.out.print("0");
			
		System.out.println(hh + timmer.substring(2,8));
	}
	
}
