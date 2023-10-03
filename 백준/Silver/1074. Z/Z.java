import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N);
		recursion(r, c, size);
		System.out.println(count);
	}
	static void recursion(int row, int col, int size){
		if (size == 1){
			return;
		}
		if (row < size/2 && col < size/2){
			recursion(row, col, size/2);
		} else if (row < size/2 && col >= size/2){
			count += (int)Math.pow(size/2, 2);
			recursion(row, col - size/2, size/2);
		} else if (row >= size/2 && col < size/2){
			count += (int)Math.pow(size/2, 2) * 2;
			recursion(row - size/2, col, size/2);
 		} else{
			count += (int)Math.pow(size/2, 2) * 3;
			recursion(row-size/2, col-size/2, size/2);
		}
	}
}
