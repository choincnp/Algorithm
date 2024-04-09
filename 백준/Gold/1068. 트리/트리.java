import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	/*
	 * 정점 N, 0번 노드부터 N-1번 노드까지 부모 주어짐, 부모 없으면 -1
	 * 마지막줄에 지울노드 표기 -> 탐색하지 않음
	 * size == 0, && visited면 count증가
	 * DFS 이용
	 */

	static int N, exclude, u, count = 0;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static ArrayList<Integer> startList;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		visited = new boolean[N];
		startList = new ArrayList<>();
		for (int i=0; i<N; i++){
			arr[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++){
			u = Integer.parseInt(st.nextToken());
			if (u == -1){
				startList.add(i);
			} else {
				arr[u].add(i);
			}
		}
		exclude = Integer.parseInt(br.readLine());
		for (Integer i : startList){
			if (i != exclude) DFS(i);
		}
		System.out.println(count);
	}
	static void DFS(int start){
		if (start == exclude) return;
		visited[start] = true;
		if (arr[start].isEmpty() || (arr[start].size() == 1 && arr[start].get(0) == exclude)) count++;
		else {
			for (Integer i : arr[start]){
				if (!visited[i]){
					DFS(i);
				}
			}
		}
	}
}