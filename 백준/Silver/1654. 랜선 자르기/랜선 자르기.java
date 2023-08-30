import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;
        for (int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i]>max) max = arr[i];
        }
        // 이제 max에서 1을 더해준다.
        max++;
        long min = 0;
        long mid = 0;

        while (min < max){ // max는 1보다 무조건 크므로 =를 안 써줘도 된다.

            //중간 길이를 구한다.
            mid = (min+max)/2;

            // 몇개로 잘라지는지를 구하는 count변수를 선언한다.
            long count = 0;

            // 이제 count를 더해나간다.
            for (int i=0; i<k; i++){
                count += arr[i]/mid;
            }

            //이제 n과 count를 비교하면서 max와 mid를 조정한다.
            if (count < n) max = mid;
            else min = mid + 1;

        }
        //upper bound로 구했으므로 오른쪽에서 하나 빼준다.
        System.out.println(min - 1);
    }
}