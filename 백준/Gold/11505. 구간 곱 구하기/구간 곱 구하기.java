import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 구간 곱 구하기
	 * 세그먼트 트리를 이용해서 구한다.
	 * N, M, K
	 * build, update, query로 쪼갠다.
	 * build는 arr, node, start, end 받는다.
	 * update는 node, start, end, inex, val 받는다.
	 * query는 node, start, end, left, right 받는다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		// 배열에 값 받기
		for (int i=1; i<N+1; i++){
			arr[i] = Long.parseLong(br.readLine());
		}
		// 세그먼트 만들기
		SegmentTree segmentTree = new SegmentTree(N);
		// 세그먼트 빌드
		segmentTree.build(arr, 1, 1, N);
		// 동작
		for (int i=0; i<M+K; i++){
			st = new StringTokenizer(br.readLine());
			long command = Long.parseLong(st.nextToken());
			long first = Long.parseLong(st.nextToken());
			long second = Long.parseLong(st.nextToken());
			if (command == 1){
				segmentTree.update(1, 1, N, (int)first, second);
			} else {
				sb.append(segmentTree.query(1, 1, N, first, second) + "\n");
			}
		}
		System.out.println(sb);
	}
	static class SegmentTree{
		long[] tree;
		SegmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2));
			int size = (int)(Math.pow(2, height+1));
			tree = new long[size];
		}
		void build(long[] arr, int node, int start, int end){
			if (start == end) {
				tree[node] = arr[start] % 1_000_000_007;
				return;
			}
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid+1, end);
			tree[node] = Math.abs((tree[node * 2] % 1_000_000_007) * (tree[node * 2 + 1] % 1_000_000_007)) % 1_000_000_007;
		}

		void update(int node, int start, int end, int index, long val){
			if (start == end){
				tree[node] = val;
				return;
			}
			int mid = (start + end) / 2;
			if (start <= index && index <= mid){
				update(node * 2, start, mid, index, val);
			} else {
				update(node * 2 + 1, mid + 1, end, index, val);
			}
			tree[node] = ((tree[node * 2] % 1_000_000_007) * (tree[node * 2 + 1] % 1_000_000_007)) % 1_000_000_007;
			return;
		}

		long query (int node, int start, int end, long left, long right){
			// 범위 바깥일 경우 RSLE
			if (right < start || left > end){
				return 1;
			}
			// 범위 내부일 경우 LSER
			if (left <= start && end <= right){
				return tree[node];
			}
			// return
			int mid = (start + end) / 2;
			long left_child = query(node * 2, start, mid, left, right);
			long right_child = query(node * 2 + 1, mid + 1, end, left, right);
			return Math.abs((left_child % 1_000_000_007) * (right_child % 1_000_000_007)) % 1_000_000_007 ;
		}
	}
}