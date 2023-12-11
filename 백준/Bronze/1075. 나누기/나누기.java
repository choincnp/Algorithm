import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();
        int start = (N/100)*100;
        for (int i=0; i<100; i++){
            if (start%F == 0) {
                System.out.println(String.format("%02d", start % 100));
                break;
            }
            start += 1;
        }
    }
}