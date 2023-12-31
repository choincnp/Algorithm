import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] arr = new int[1001];
        int cnt = 0;
        for (int i=1; i<1001; i++){
            if (i<100){
                cnt++;
            } else if (i<1000) {
                int tmp = i;
                int third = tmp%10;
                tmp /= 10;
                int second = tmp%10;
                tmp /= 10;
                int first = tmp%10;
                if ((first - second) == (second - third)) cnt++;
            }
            arr[i] = cnt;
        }
        System.out.println(arr[target]);
    }
}