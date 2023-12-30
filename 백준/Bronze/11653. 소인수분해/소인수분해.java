import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        int tmp = 2;
        while (num != 1){
            if (num % tmp == 0){
                num /= tmp;
                sb.append(tmp).append("\n");
            } else {
                tmp++;
            }
        }
        System.out.println(sb);
    }
}