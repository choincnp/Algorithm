import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 세그먼트 트리 대표문제
	 * build, query, update를 기준으로 한다.
	 * N을 받아서 4N의 노드를 가지는 트리를 만들고
	 * build를 통해 전이진트리를 만든다.
	 * switch문으로 1이라면 query, 2라면 update를 실행한다.
	 */
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 값 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 값 배열 초기화
		long[] arr = new long[N + 1];
		// 세그먼트 트리 초기화
		SegmentTree segmentTree = new SegmentTree(N);
		// 배열 채우기
		for (int i=1; i<N+1; i++){
			arr[i] = Long.parseLong(br.readLine());
		}
		// 트리 채우기
		segmentTree.build(arr, 1, 1, N);

		for (int i=0; i<M+K; i++){
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			long first = Long.parseLong(st.nextToken());
			long second = Long.parseLong(st.nextToken());
			if (command == 1){
				segmentTree.update(1, 1, N, first, second);
			} else {
				System.out.println(segmentTree.query(1, 1, N, first, second));
			}
		}
	}
	static class SegmentTree{
		private long[] tree;
		SegmentTree(int N){
			//트리의 높이 계산
			double height = Math.ceil(Math.log(N) / Math.log(2) + 1);
			int size = (int)Math.pow(2, height);
			tree = new long[size];
		}
		void build (long[] arr, int node, int start, int end){
			if(start == end) {
				tree[node] = arr[start];
				return;
			}
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid+1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}

		long query (int node, int start, int end, long left, long right){
			if (right < start || left > end) return 0;
			if (left <= start && end <= right) return tree[node];
			int mid = (start + end) / 2;
			long left_child = query(node * 2, start, mid, left, right);
			long right_child = query(node * 2 + 1, mid+1, end, left, right);
			return left_child + right_child;
		}

		void update(int node, int start, int end, long index, long val){
			if (start == end) {
				tree[node] = val;
				return;
			}
			int mid = (start + end) / 2;
			if (start <= index && index <= mid){
				update(node * 2, start, mid, index, val);
			} else {
				update(node * 2 + 1, mid + 1, end,  index, val);
			}
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
			return;
		}
	}
}