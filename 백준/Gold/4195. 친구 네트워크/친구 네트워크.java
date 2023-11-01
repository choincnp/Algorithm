import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] count;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		while (N-- > 0){
			M = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			parent = new int[M*2];
			count = new int[M*2];
			for (int i=0; i<M*2; i++){
				parent[i] = i;
				count[i] = 1;
			}
			int idx = 0;
			for (int i=0; i<M; i++){
				String[] relationship = br.readLine().split(" ");
				for (int j=0; j<2; j++){
					if (!map.containsKey(relationship[j])){
						map.put(relationship[j], idx++);
					}
				}
				sb.append(union(map.get(relationship[0]), map.get(relationship[1]))).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int find(int a){
		return a == parent[a] ? a : (parent[a] = find(parent[a]));
	}
	static int union(int a, int b){
		a = find(a);
		b = find(b);
		if (a != b){
			parent[b] = a;
			count[a] += count[b];
		}
		return count[a];
	}
}