import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 4 * stats[4] - (stats[0] + stats[1] + stats[2] + stats[3]);
        if (min < 0){
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
