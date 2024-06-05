import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int quarters;
        int one, two, three;
        int counter = 0;

        // 입력 받기
        quarters = Integer.parseInt(br.readLine());
        one = Integer.parseInt(br.readLine());
        two = Integer.parseInt(br.readLine());
        three = Integer.parseInt(br.readLine());

        // 게임 진행
        while (quarters > 0) {
            quarters--;
            counter++;
            one++;
            if (one == 35) {
                quarters += 30;
                one = 0;
            }
            if (quarters == 0) {
                break;
            }

            quarters--;
            counter++;
            two++;
            if (two == 100) {
                quarters += 60;
                two = 0;
            }
            if (quarters == 0) {
                break;
            }

            quarters--;
            counter++;
            three++;
            if (three == 10) {
                quarters += 9;
                three = 0;
            }
            if (quarters == 0) {
                break;
            }
        }

        System.out.println("Martha plays " + counter + " times before going broke.");
    }
}