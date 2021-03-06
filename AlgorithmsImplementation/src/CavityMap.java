import java.util.Scanner;


public class CavityMap {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for(int i=0; i<n; i++){
			String line = in.next();
			for(int j=0; j<n; j++){
				grid[i][j] = Integer.parseInt(""+line.charAt(j));
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(i>0 && i<n-1 && j>0 && j<n-1){
					int cavCell = grid[i][j];
					if(grid[i-1][j] < cavCell && grid[i+1][j] < cavCell &&
							grid[i][j-1] < cavCell && grid[i][j+1] < cavCell){
						System.out.print('X');
					}else{
						System.out.print(grid[i][j]);
					}
				}else{
					System.out.print(grid[i][j]);
				}
				
			}
			System.out.println();
		}
	}

}
