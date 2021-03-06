import java.util.Scanner;


public class ACMICPCTeam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		String[] hacker = new String[N];
		for(int i=0; i<N; i++){
			hacker[i] = in.next();
		}
		
		int maxTopic = 0;
		
		//start with first person
		for(int curIdx=0; curIdx<N; curIdx++){
			//compare with next person onwards, follow n(n-1)/2
			for(int cmpIdx=curIdx+1; cmpIdx<N; cmpIdx++){
				int topicCount = compareRetNum(hacker[curIdx],hacker[cmpIdx], M);
				if(maxTopic < topicCount) maxTopic = topicCount;
			}
		}
		System.out.println(maxTopic);
		
		int matches = 0;
		for(int curIdx=0; curIdx<N; curIdx++){
			//compare with next person onwards, follow n(n-1)/2
			for(int cmpIdx=curIdx+1; cmpIdx<N; cmpIdx++){
				if(compareRetNum(hacker[curIdx],hacker[cmpIdx], M) == maxTopic) matches++;
			}
		}
		
		System.out.println(matches);
	}
	
	public static int compareRetNum(String s1, String s2, int M){
		int count = 0;
		for(int i=0; i<M; i++){
			if((s1.charAt(i)=='1') || (s2.charAt(i)=='1')) count++;
		}
		return count;
	}
	
}
