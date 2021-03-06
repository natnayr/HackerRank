import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class LibraryFine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
		
        try{
	        //check date is valid
	        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        df.setLenient(false);
	        df.parse(d1+"-"+m1+"-"+y1);
	        df.parse(d2+"-"+m2+"-"+y2);
			
        }catch(java.text.ParseException  e){
        	e.printStackTrace();
        }
        
        if(y1 > y2){
        	//diff year
        	System.out.println(10000);
        }else if(y1 == y2){
        	if(m1 > m2){
        		//diff month
        		System.out.println((m1-m2) * 500);
        	}else if(m1 == m2){
        		if(d1 > d2){
        			//diff day
        			System.out.println((d1-d2) * 15);
        		}else{
        			System.out.println(0);
        		}
        	}else{
            	System.out.println(0);
            }
        }else{
        	System.out.println(0);
        }
	}

}
