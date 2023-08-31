import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String star = "*";
        int k = sc.nextInt();
        IntStream.rangeClosed(0,k).forEach(i -> System.out.println(star.repeat(k-i)));
    }
}