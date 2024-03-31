import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] field = new char[N][N];
		int row = 0;
		int column = 0;
		for (int i=0; i<N; i++){
			String line = br.readLine();
			String[] temparr = line.split("X");
			row += Arrays.stream(temparr).filter(lt -> lt.contains("..")).count();
			for (int j=0; j<N; j++){
				field[j][N-i-1] = line.charAt(j);
			}
		}
		for (int i=0; i<N; i++){
			String horizontal = "";
			for (int j=0; j<N; j++){
				horizontal += field[i][j];
			}
			String[] temparr2 = horizontal.split("X");
			column += Arrays.stream(temparr2).filter(lt -> lt.contains("..")).count();
		}
		System.out.println(row + " " + column);
	}
}