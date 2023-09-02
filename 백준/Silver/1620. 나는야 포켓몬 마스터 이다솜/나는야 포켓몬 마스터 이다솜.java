import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> index = new HashMap<>();
        String[] index2 = new String[T];
        for (int i=0; i<T; i++){
            String pokemon = br.readLine();
            index.put(pokemon, i);
            index2[i] = pokemon;
        }
        for (int i=0; i<Q; i++){
            String command = br.readLine();
            if (Character.isDigit(command.charAt(0))) sb.append(index2[Integer.parseInt(command)-1]).append("\n");
            else sb.append(index.get(command)+1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
