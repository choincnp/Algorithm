import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int room = Integer.parseInt(br.readLine());
		int[] num = new int[10];
		while (room > 0){
			int r = room%10;
			if (r == 6 || r == 9){
				if (num[6] > num[9]) num[9]++;
				else num[6]++;
			} else {
				num[r]++;
			}
			room /= 10;
		}
		int max = 0;
		for (int i=0; i<10; i++){
			if (max < num[i]) max = num[i];
		}
		System.out.println(max);
	}
}
