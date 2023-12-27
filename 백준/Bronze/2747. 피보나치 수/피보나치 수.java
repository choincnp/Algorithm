import java.util.*;
public class Main{
    static int[] fib;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib = new int[46];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<46; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println(fib[n]);
    }
}