import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(arr, 0, N-1, K-1);
		System.out.println(arr[K-1]);

	}

	public static void quickSort(int[] A, int start, int end, int k){
		if (start < end){
			int pivot = partition(A, start, end);
			if (pivot == k){
				return;
			} else if (pivot > k){
				quickSort(A, start, pivot - 1, k);
			} else {
				quickSort(A, pivot + 1, end, k);
			}
		}
	}

	public static int partition(int[] A, int start, int end){
		if (start + 1 == end){
			if (A[start] > A[end]){
				swap(A, start, end);
			}
			return end;
		}
		int middle = (start + end) / 2;
		swap(A, start, middle);
		int pivot = A[start];
		int i = start + 1;
		int j = end;
		while (i <= j){
			while (pivot < A[j] && j>0) j--;
			while (pivot > A[i] && i < A.length - 1) i++;
			if (i <= j){
				swap(A, i++, j--);
			}
		}
		A[start] = A[j];
		A[j] = pivot;
		return j;
	}

	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}