import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] students = new boolean[31];
		for (int i=0; i<28; i++){
			int check = Integer.parseInt(br.readLine());
			students[check] = true;
		}
		for (int i=1; i<=30 ; i++){
			if (!students[i]) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
