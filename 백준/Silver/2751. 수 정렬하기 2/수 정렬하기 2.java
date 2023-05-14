import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> pocket = new ArrayList<>();
		for (int i=0 ; i < N; i++){
			pocket.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(pocket);
		StringBuilder sb = new StringBuilder();
		for (Integer integer : pocket) {
			sb.append(integer).append("\n");
		}
		System.out.println(sb);
	}
}