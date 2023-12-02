import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (int)Math.abs(Math.pow(a,2)-Math.pow(c,2));

        System.out.println(b_square);
    }
}