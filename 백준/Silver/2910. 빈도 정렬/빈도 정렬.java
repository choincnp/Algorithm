import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<T; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            index.add(num);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Collections.sort(list,
            (o1, o2) -> {
            if (map.get(o1) == map.get(o2)){
                return index.indexOf(o1) - index.indexOf(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
