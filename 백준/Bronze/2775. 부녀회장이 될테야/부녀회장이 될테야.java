import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner T = new Scanner(System.in);
        int c = T.nextInt();
        int[][] arr = new int[15][15];

        // 아파트 기본층 설정
        for (int i=0; i<15; i++){
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        // 나머지 층 채우기
        for (int i=1; i<15; i++){
            for (int j=2; j<15; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        for (int i=0; i<c; i++){
            int k = T.nextInt();
            int n = T.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
