import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		int N = sc.nextInt();
		while (N-->0){
			int num = sc.nextInt();
			if(num == 0){
				if(pQueue.isEmpty()){
					sb.append(0).append("\n");
				}else{
					sb.append(pQueue.poll()).append("\n");
				}
			}else{
				pQueue.add(num);
			}
		}
		System.out.println(sb);
	}
}