import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 세그먼트 트리 대표문제
	 * build, find 메서드
	 * build를 통해 전이진트리를 만든다.
	 * 각 노드에는 최댓값, 최솟값 정보 있어야 함
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 값 받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N+1];
		SegmentTree segmentTree = new SegmentTree(N);
		//배열에 수 받기
		for (int i=1; i<N+1; i++){
			arr[i] = Long.parseLong(br.readLine());
		}
		segmentTree.build(arr, 1, 1, N);
		for (int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			long[] result = segmentTree.query(1, 1, N, left, right);
			sb.append(result[0] + " " + result[1] + "\n");
		}
		System.out.println(sb);
	}
	static class SegmentTree{
		private long[][] tree;
		SegmentTree(int N){
			//트리의 높이 계산
			double height = Math.ceil(Math.log(N) / Math.log(2) + 1);
			int size = (int)Math.pow(2, height);
			tree = new long[size][2];
		}
		void build (long[] arr, int node, int start, int end){
			if(start == end) {
				// 루트 노드일경우 최댓값에 수 저장한다. 2차원 배열 쓸지, ArrayList쓸지는 조금 더 고민해봐야 할듯?
				tree[node][0] = arr[start];
				tree[node][1] = arr[start];
				return;
			}
			int mid = (start + end) / 2;
			build(arr, node * 2, start, mid);
			build(arr, node * 2 + 1, mid+1, end);
			tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
			tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
		}

		long[] query(int node, int start, int end, int left, int right){
			// 범위를 벗어났을 경우
			if (left > end || right < start){
				return new long[]{Long.MAX_VALUE, Long.MIN_VALUE}; // 수정된 부분
			}
			// 범위 안일 경우
			if (left <= start && end <= right) return new long[]{tree[node][0], tree[node][1]};
			int mid = (start + end) / 2;
			long[] left_child = query(node * 2, start, mid, left, right);
			long[] right_child = query(node * 2 + 1, mid+1, end, left, right);
			return new long[]{Math.min(left_child[0], right_child[0]), Math.max(left_child[1], right_child[1])};
		}
	}
}