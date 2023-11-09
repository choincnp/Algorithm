import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String tmp = br.readLine();
        for (int i=0; i<tmp.length(); i++){
            left.push(tmp.charAt(i));
        }
        N = Integer.parseInt(br.readLine());
        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "L" :
                    if (!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case "D" :
                    if (!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case "B" :
                    if (!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case "P" :
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }
        while (!left.isEmpty()){
            sb.append(left.pop());
        }
        sb.reverse();
        while (!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}