import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		int count = 0;
		ArrayList<Integer> coin = new ArrayList<>();
		for (int i=0; i<N; i++){
			coin.add(Integer.parseInt(br.readLine()));
		}
		while (price > 0){
			int temp = coin.get(coin.size()-1);
			if (price >= temp){
				price -= temp;
				count++;
			}
			else{
				coin.remove(coin.size()-1);
			}
		}
		System.out.println(count);
	}
}