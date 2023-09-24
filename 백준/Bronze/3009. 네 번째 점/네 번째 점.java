import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> width = new ArrayList<>();
		ArrayList<Integer> height = new ArrayList<>();
		for (int i=0; i<3; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			width.add(A);
			height.add(B);

		}
		int w = 0;
		int h = 0;
		if (width.get(0).equals(width.get(1))){
			w = width.get(2);
		} else if (width.get(0).equals(width.get(2))){
			w = width.get(1);
		} else {
			w = width.get(0);
		}
		if (height.get(0).equals(height.get(1))){
			h = height.get(2);
		} else if (height.get(0).equals(height.get(2))){
			h = height.get(1);
		} else {
			h = height.get(0);
		}
		sb.append(w).append(" ").append(h);
		System.out.println(sb.toString());
	}
}