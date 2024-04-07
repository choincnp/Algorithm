
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * N개의 줄 사야함, 6줄 패키지, 1개 이상의 낱개줄
	 * 브랜드 M개
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] setMenu = new int[M];
		int[] singleMenu = new int[M];

		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			setMenu[i] = Integer.parseInt(st.nextToken());
			singleMenu[i] = Integer.parseInt(st.nextToken());
		}
		int price = 0;
		Arrays.sort(setMenu);
		Arrays.sort(singleMenu);

		price = Math.min(Math.min(((N/6)+1) * setMenu[0], N * singleMenu[0]), (N/6) * setMenu[0] + (N%6) * singleMenu[0]);
		System.out.println(price);
	}
}
