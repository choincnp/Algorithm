import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] three = new int[3];
        for (int i=0; i<3; i++){
            three[i] = sc.nextInt();
        }
        Arrays.sort(three);
        System.out.println(three[1]);
    }
}