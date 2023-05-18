import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		int count = 0;
		int[] prime = new int[(int)Math.ceil(Math.sqrt(M))+1];
		for (int i=0; i<prime.length; i++){
			prime[i] = i;
		}
		for (int i=2; i<prime.length; i++){
			if (prime[i] == 0) continue;
			for (int j=i+i; j<prime.length; j+=i){
				prime[j] = 0;
			}
		}
		for (int i=2; i< prime.length; i++){
			if (prime[i] != 0){
				int num = prime[i];
				int idx = 2;
				while (true){
					if (Math.pow(num,idx) > M) break;
					if (Math.pow(num,idx) >= N && Math.pow(num,idx) <= M) {
						count++;
					}
					idx++;
				}
			}
		}
		System.out.println(count);
	}
}