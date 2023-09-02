import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++){
            int Q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            while (Q-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    tree.put(num, tree.getOrDefault(num, 0)+1);
                }
                else if (tree.size() == 0) continue;
                else{
                    int key = num == 1? tree.lastKey() : tree.firstKey();
                    int count = tree.get(key);
                    if (count == 1) {
                        tree.remove(key);
                    } else {
                        tree.put(key, count - 1);
                    }
                }

            }
            if (tree.size()==0) sb.append("EMPTY").append("\n");
            else sb.append(tree.lastKey()).append(" ").append(tree.firstKey()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
