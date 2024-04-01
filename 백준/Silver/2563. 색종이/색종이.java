import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		field = new boolean[100][100];
		int T = Integer.parseInt(br.readLine());
		while (T -- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i=x; i< x+10; i++){
				for (int j=y; j<y+10; j++){
					field[i][j] = true;
				}
			}
		}
		int count = 0;
		for (int i=0; i<100; i++){
			for (int j=0; j<100; j++){
				if (field[i][j]) count++;
			}
		}
		System.out.println(count);
	}
}
