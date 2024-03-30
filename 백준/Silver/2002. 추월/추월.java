import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int carsNum = Integer.parseInt(br.readLine());
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		for (int i=0; i<carsNum; i++){
			queue.offer(br.readLine());
		}

		for (int i=0; i<carsNum; i++){
			// 나온 차량
			String car = br.readLine();
			// 이미 추월차량으로 등록됐으면 바로 제낌 (대수만 필요하기 때문)
			while (!queue.isEmpty() && set.contains(queue.peek())){
				queue.poll();
			}
			// 추월이 발생했을 경우
			if (!queue.isEmpty() && !queue.peek().equals(car)){
				set.add(car);
			} else if (!queue.isEmpty()){
				queue.poll();
			}
		}
		System.out.println(set.size());
	}
}
