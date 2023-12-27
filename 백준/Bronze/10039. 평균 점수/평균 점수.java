import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i=0; i<5; i++){
            int tmp = sc.nextInt();
            if (tmp < 40){
                sum += 40;
            } else sum += tmp;
        }
        System.out.println(sum/5);
    }
}