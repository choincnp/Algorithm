import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int x1, y1, x2, y2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			while (N-- > 0){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				if (isIn(x, y, r)) count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	static boolean isIn(int x, int y, int r){
		if (length(x, y, x1, y1) > r && length(x, y, x2, y2) > r) return false;
		else if (length(x, y, x1, y1) < r && length(x, y, x2, y2) < r) return false;
		else return true;
	}

	static double length(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
	}
}
