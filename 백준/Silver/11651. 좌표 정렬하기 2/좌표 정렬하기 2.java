import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> array = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++){
			array.add(br.readLine());
		}
		Collections.sort(array, (o1, o2) -> {
			int x1 = Integer.parseInt(o1.split(" ")[0]);
			int x2 = Integer.parseInt(o2.split(" ")[0]);
			int y1 = Integer.parseInt(o1.split(" ")[1]);
			int y2 = Integer.parseInt(o2.split(" ")[1]);
			if (y2 == y1) return x1-x2;
			else return y1-y2;
		});
		for (String s : array){
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}