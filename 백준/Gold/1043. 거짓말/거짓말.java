import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static int[] parent, truth;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		truth = new int[T];
		for (int i=0; i<T; i++){
			truth[i] = Integer.parseInt(st.nextToken());
		}
		party = new ArrayList[M];
		for (int i=0; i<M; i++){
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			while (size-- > 0){
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		parent = new int[N+1];
		for (int i=0; i<N+1; i++){
			parent[i] = i;
		}
		//각 파티에 참여한 사람들을 한 그룹으로 만든다
		for (int i=0; i<M; i++){
			int first = party[i].get(0);
			for (int j=1; j<party[i].size(); j++){
				union(first, party[i].get(j));
			}
		}
		int count = 0;
		for (int i=0; i<M; i++){
			boolean check = true;
			int cur = party[i].get(0);
			for (int j=0; j<truth.length; j++){
				if (find(cur) == find(truth[j])){
					check = false;
					break;
				}
			}
			if (check) count++;
		}
		System.out.println(count);
	}
	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if (a != b){
			parent[b] = a;
		}
	}
	static int find(int a){
		return a == parent[a] ? a : (parent[a] = find(parent[a]));
	}
}