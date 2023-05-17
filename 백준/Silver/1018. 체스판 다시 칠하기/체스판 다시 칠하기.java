import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][M];
		for (int i=0; i<N; i++){
			String line = br.readLine();
			for (int j=0; j<M; j++){
				if (line.charAt(j) == 'W'){
					arr[i][j] = true;
				}
				else{
					arr[i][j] = false;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i=0; i<N-7; i++){
			for (int j=0; j<M-7; j++){
				if (min > paintCheck(arr, i, j)){
					min = paintCheck(arr, i, j);
				}
			}
		}
		System.out.println(min);
	}
	public static int paintCheck(boolean[][] arr, int x, int y){ // 0, 0 넣으면 7,7까지 돌아야함
		int count = 0;
		boolean prev = arr[x][y];
		for (int i=x; i<x+8; i++){
			for (int j=y; j<y+8; j++){
				if (arr[i][j] != prev){
					count++;
				}
				prev = !prev;
			}
			prev = !prev;
		}
		return Math.min(count, 64-count);
	}
}