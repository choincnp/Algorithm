import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, tmp;
    static int count, result, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        result = -1;
        count = 0;
        arr = new int[T];
        tmp = new int[T];
        for (int i=0; i<T; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, arr.length-1);
        System.out.println(result);

    }
    static void recursion(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= high){
            if (arr[i] <= arr[j]){
                tmp[t++] = arr[i++];
            }
            else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid){
            tmp[t++] = arr[i++];
        }
        while (j <= high){
            tmp[t++] = arr[j++];
        }
        i = low;
        t = 0;
        while (i <= high){
            count++;
            if (count == N) {
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }

    static void merge_sort(int[] array, int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            merge_sort(array, low, mid);
            merge_sort(array, mid+1, high);
            recursion(array, low, mid, high);
        }
    }
}
