import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int back = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command){
				case "push":
					int num = Integer.parseInt(st.nextToken());
					queue.add(num);
					back = num;
					break;
				case "pop":
					if (queue.isEmpty()){
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.poll()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					if (queue.isEmpty()){
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()){
						sb.append(-1).append("\n");
					} else {
						sb.append(back).append("\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
	}
}