import java.util.Scanner;


public class TheGridSearch {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            boolean match = false;
            boolean escape = false;
            //Run through and find first line match
            for(int G_i=0; G_i<R && match == false; G_i++){
            	for(int G_j=0; G_j<C && match == false; G_j++){
            		//run through of big matrix, start from check gate
            		int num = r*c;
                    escape = false;
            		if(G[G_i].charAt(G_j) == P[0].charAt(0)){
            			for(int i=0, g_i=G_i; i<r && g_i<R && match == false && escape == false; i++, g_i++){
            				for(int j=0, g_j=G_j; j<c && g_j<C && match == false && escape == false; j++, g_j++){
            					if(G[g_i].charAt(g_j) != P[i].charAt(j)){
            						escape = true;
            					}else{
            						num--;
            						if(num == 0){
                        				match = true;
                        					
                        			}
            					}	
            				}
            			}
            			
            		}
            	}
            }
            if(match == true){
            	System.out.println("YES");
            }else{
            	System.out.println("NO");            	
            }
        }
        
	}
	
	
	
}
