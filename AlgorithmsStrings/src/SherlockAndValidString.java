import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class SherlockAndValidString {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		
		String word = in.next();
		
		for(int i=0; i<word.length(); i++){
			char letter = word.charAt(i);
			if(map.get(letter) == null){
				map.put(word.charAt(i), 1);
			}else{
				map.put(word.charAt(i), map.get(letter) + 1);
			}
		}
		
		//sort all list items
		ArrayList<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list, new ValComparator());
		
		//count repetitions and get number of the highest repetition
		int[] repArr = new int[list.get(0)+1];
		Iterator<Integer> lit = list.iterator();
		while(lit.hasNext()){
			int num = lit.next();
//			System.out.print(num  + ",");
			repArr[num]++;
		}
//		System.out.println();
		
		int max = 0;
		for(int i=0; i<repArr.length; i++){
//			System.out.print(repArr[i] + ":");
			if(max < repArr[i]){
				max = i;
			}
		}
//		System.out.println();

//		System.out.println("max:" + max);
	
		int diff=0, oneOcc = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i) == 1 && list.get(i) != max){
				oneOcc++;
			}
			
			if(list.get(i) != 0 && list.get(i) != max){
				if(list.get(i) != 1 && oneOcc <=1){
				diff += Math.abs(list.get(i) - max);
				}
			}
		}
		
		if(oneOcc > 1 || diff > 1){
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}
		
	}
}

class ValComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer e1, Integer e2) {
        // write comparison logic here like below , it's just a sample
        if(e1 < e2){
        	return 1;
        }else if(e1 == e2){
        	return 0;
        }else{
        	return -1;
        }
    }
}
