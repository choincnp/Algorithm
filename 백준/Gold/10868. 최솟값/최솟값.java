import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 세그먼트 트리 복습
	 * Build, Query, Update로 나눈다.
	 * int[][], Math.min 사용
	 * 영향 없으려면 Long,MAX_LONG_VALUE 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		SegmentTree segmentTree = new SegmentTree(N);
		for (int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		segmentTree.build(arr, 1, 1,  N);
		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(segmentTree.query(1, 1, N, a, b) + "\n");
		}
		System.out.println(sb);



	}
	static class SegmentTree{
		long[] tree;

		//생성자
		SegmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2));
			int size = (int)Math.pow(2, height+1) ;
			tree = new long[size];
		}

		//build
		void build(int[] arr, int node, int start, int end){
			if (start == end) {
				tree[node] = arr[start];
				return;
			}
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid + 1, end);
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
		void update(int node, int start, int end, int index, long val){
			if (start == end){
				tree[index] = val;
			}
			int mid = (start + end) / 2;
			if (start <= index && index <= mid){
				update(node * 2, start, mid, index, val);
			} else {
				update(node * 2 + 1, mid + 1, end, index, val);
			}
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}

		long query(int node, int start, int end, int left, int right){
			if (right < start || end < left){
				return Long.MAX_VALUE;
			}
			if (left <= start && end <= right){
				return tree[node];
			}
			int mid = (start + end) / 2;
			long left_child = query(node * 2, start, mid, left, right);
			long right_child = query(node * 2 + 1, mid + 1, end, left, right);
			return Math.min(left_child, right_child);
		}
	}
}