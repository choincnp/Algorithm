import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			int floor = num % height == 0 ? height : num % height;
			int room = (double)num / height % 1 == 0? num / height : num / height + 1;
			sb.append(floor);
			if (room < 10){
				sb.append("0");
			}
			sb.append(room);
			System.out.println(sb);
		}
	}
}