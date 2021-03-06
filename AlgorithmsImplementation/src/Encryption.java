import java.util.Scanner;


public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String message = in.next().trim();
		int nrow = (int) Math.floor(Math.sqrt(message.length()));
		int ncol = (int) Math.ceil(Math.sqrt(message.length()));
		
		if((nrow*ncol) < message.length()){
			nrow++;
		}
		
		char[][] box = new char[nrow][ncol];
		
		int m = 0;
		
		for(int i=0; i< nrow; i++){
			for(int j=0; j<ncol; j++){
				if(m < message.length()){
					box[i][j] = message.charAt(m);
					m++;
				}else{
					//break out
					i=nrow;
					j=ncol;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j< ncol; j++){
			for(int i=0; i<nrow; i++){
				if(box[i][j] >= 'a' && box[i][j] <='z'){
					sb.append(box[i][j]);
				}
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
