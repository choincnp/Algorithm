import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, white, blue;
	static StringTokenizer st;
	static int[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursion(0, 0, N);
		sb.append(white).append("\n").append(blue);
		System.out.println(sb.toString());
	}
	static void recursion(int row, int column, int size){
		if (fieldCheck(row, column, size)){
			if (field[row][column] == 0) white++;
			else blue++;
			return;
		}
		int newSize = size/2;
		recursion(row, column, newSize);
		recursion(row+newSize, column, newSize);
		recursion(row, column+newSize, newSize);
		recursion(row+newSize, column+newSize, newSize);
	}

	static boolean fieldCheck(int row, int column, int size){
		int color = field[row][column];
		for (int i=row; i<row+size; i++){
			for (int j=column; j<column+size; j++){
				if (field[i][j] != color) return false;
			}
		}
		return true;
	}
}
