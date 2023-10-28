import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[][] city;
	static int[] route;
	static int[] parent;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		city = new int[N+1][N+1];
		//도시 연결정보 채우기
		for (int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<N+1; j++){
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		route = new int[M+1];
		st = new StringTokenizer(br.readLine());
		// route 채우기
		for (int i=1; i<=M; i++){
			route[i] = Integer.parseInt(st.nextToken());
		}
		// 대표 노드 만들고 채우기
		parent = new int[N+1];
		for (int i=1; i<N+1; i++){
			parent[i] = i;
		}

		// 대표노드 합치기
		for (int i=1; i<N+1; i++){
			for (int j=1; j<N+1; j++){
				if (city[i][j] == 1) union(i, j);
			}
		}
		//route에 담겨있는 도시들이 같은 union인지 확인
		int check = find(route[1]);
		for (int i=2; i<M+1; i++){
			if (check != find(route[i])){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}
	static int find(int a){
		return a==parent[a] ? a : (parent[a] = find(parent[a]));
	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if (a != b) parent[b] = a;
	}
}