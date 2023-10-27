import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		union = new int[N+1];
		for (int i=0; i<=N; i++){
			union[i] = i;
		}
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(command == 0){
				union(A, B);
			}
			else {
				if (checkSame(A,B)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if (a!=b) union[b] = a;
	}
	static boolean checkSame(int a, int b){
		int A = find(a);
		int B = find(b);
		return A==B;
	}
	static int find(int a){
		// a가 대표 노드면 a를 리턴하고, 대표 노드가 아니라면 재귀함수로 들어가서 대표노드인지 검색하고 나올때 전부다 대표노드로 바꿔준다.
		return union[a] == a ? a : (union[a] = find(union[a]));
	}
}