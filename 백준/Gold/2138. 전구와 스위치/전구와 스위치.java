import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long count;
	static boolean isAble;
	static char[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] get1 = br.readLine().toCharArray();
		char[] get2 = new char[get1.length];
		for (int i=0; i<get2.length; i++){
			if (i==0 || i==1){
				get2[i] = get1[i] == '0' ? '1' : '0';
			} else {
				get2[i] = get1[i];
			}
		}
		answer = br.readLine().toCharArray();
		// 010과 100을 010과 비교홰서 최솟값을 찾으면 된다.
		bulb(get1);
		long ans1 = isAble ? count : Integer.MAX_VALUE;
		bulb(get2);
		long ans2 = isAble ? count : Integer.MAX_VALUE;
		if (ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE){
			System.out.println("-1");
		} else {
			System.out.println(Math.min(ans1, ans2+1));
		}

	}
	static void bulb(char[] arr){
		count = 0;
		isAble = false;
		for (int i=1; i<N; i++){
			if (arr[i-1] != answer[i-1]){
				arr[i-1] = arr[i-1] == '0' ? '1' : '0';
				arr[i] = arr[i] == '0' ? '1' : '0';
				if (i != N-1){
					arr[i+1] = arr[i+1] == '0' ? '1' : '0';
				}
				count++;
			}
		}
		if (arr[N-1] == answer[N-1]) isAble = true;
	}
}
