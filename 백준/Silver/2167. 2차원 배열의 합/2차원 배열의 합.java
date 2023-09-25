import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		while (K -- > 0){
			long sum = 0;
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a = i-1; a < x; a++){
				for (int b= j-1; b < y; b++){
					sum += arr[a][b];
				}
			}
			System.out.println(sum);
		}
	}
}