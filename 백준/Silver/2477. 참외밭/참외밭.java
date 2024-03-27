import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qt = Integer.parseInt(br.readLine());
		int[][] field = new int[7][2];
		for (int i=0; i<6; i++){
			st = new StringTokenizer(br.readLine());
			field[i][0] = Integer.parseInt(st.nextToken());
			field[i][1] = Integer.parseInt(st.nextToken());
		}
		field[6][0] = field[0][0];
		field[6][1] = field[0][1];
		int all = 0;
		int selected = 0;
		for (int i=1; i<=6; i++){
			all = Math.max(all, field[i-1][1] * field[i][1]);
			selected += field[i-1][1] * field[i][1];
		}
		System.out.println(qt * (all - (all * 3 - selected)));
	}
}