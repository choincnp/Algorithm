import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] array = new long[91];
        array[1] = 1;
        array[2] = 1;
        array[3] = 2;
        for (int i=4; i<91; i++){
            array[i] = array[i-1] + array[i-2];
        }
        System.out.println(array[N]);
    }
}