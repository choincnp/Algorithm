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
		//추월차량 대수
		int over = 0;

		for (int i=0; i<carsNum; i++){
			// 나온 차량
			String car = br.readLine();
			while (!queue.isEmpty() && set.contains(queue.peek())){
				queue.poll();
			}
			if (!queue.isEmpty() && !queue.peek().equals(car)){
				over++;
				set.add(car);
			} else if (!queue.isEmpty()){
				queue.poll();
			}
		}
		System.out.println(over);
	}
}