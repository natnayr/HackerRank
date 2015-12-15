import java.util.Scanner;

public class RunningTimeOfQuickSort {

	public static int QSSwaps;
	public static int ISSorts;
	
	public static void main(String[] args) {
		QSSwaps = 0;
		ISSorts = 0;
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] arr = new int[T];
		for(int i=0; i<T; i++){
			arr[i] = in.nextInt();
		}
		
		int[] arr2 = arr.clone();
		
		quickSort(arr, 0, arr.length-1);
		
		insertSort(arr2);
		in.close();
		
		System.out.println(ISSorts - QSSwaps);
	}
	
	static void insertSort(int[] arr){
		
		for(int i=1; i<arr.length; i++){
			if(arr[i-1] > arr[i]){
				for(int j=i; j>0; j--){
					if(arr[j-1] < arr[j] ){
						break;
					}
					swap(arr, j-1, j);
					ISSorts++;
					
				}
			}
		}
	}
	
	// sort all letters left of
	static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int p = partition(arr, lo, hi);
		quickSort(arr, lo, p - 1);
		quickSort(arr, p + 1, hi);
	}

	static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo;
		for (int j = lo; j < hi; j++) {
			
			if (arr[j] <= pivot) {
				QSSwaps++;
				swap(arr, i, j);
				i++;
			}
		}
		QSSwaps++;
		swap(arr, hi, i);
		return i;
	}

	static void swap(int[] arr, int i, int j) {
		
		int k = arr[i];
		arr[i] = arr[j];
		arr[j] = k;
	}

}
