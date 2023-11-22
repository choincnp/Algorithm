import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static boolean[] visited = new boolean[21];
    static long[] punc = new long[21];
    static int[] s = new int[21];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        punc[0] = 1;
        for (int i=1; i<=N; i++){
            punc[i] = punc[i-1] * i;
        }
        st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());
        if (command == 1){
            long K = Long.parseLong(st.nextToken());
            for (int i=1; i<=N; i++){
                for (int j=1, cnt = 1; j<=N; j++){
                    if (visited[j]) continue;
                    if (K <= cnt*punc[N-i]){
                        K -= ((cnt-1) * punc[N-i]);
                        s[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i=1; i<=N; i++){
                System.out.print(s[i] + " ");
            }
        } else {
            long K = 1;
            for (int i=1; i<=N; i++){
                s[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j=1; j< s[i]; j++){
                    if (!visited[j]) cnt++;
                }
                K += cnt * punc[N-i];
                visited[s[i]] = true;
            }
            System.out.println(K);
        }
    }
}