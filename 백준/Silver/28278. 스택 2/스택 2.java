import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>(); //스택 생성
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("1"))stack.push(Integer.parseInt(st.nextToken()));
			else if(command.equals("2"))
			{
				if(!stack.isEmpty())
				{
					sb.append(stack.lastElement()).append("\n");
					stack.pop();
				}
				else sb.append(-1).append("\n");
			}
			else if(command.equals("3")) sb.append(stack.size()).append("\n");
			else if(command.equals("4")) 
				if(stack.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			else if(command.equals("5"))
				if(stack.isEmpty())sb.append(-1).append("\n");
				else sb.append(stack.lastElement()).append("\n");
		}
		br.close();
		System.out.println(sb);
	}
}