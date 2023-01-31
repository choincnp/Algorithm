import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int paid = sc.nextInt();
        int change = 1000 - paid;
        int answer = 0;
        int[] coin = {500,100,50,10,5,1};
        for (int i=0; i<coin.length; i++){
            if (change >= coin[i]){
                answer += change/coin[i];
                change %= coin[i];
            }
        }
        System.out.println(answer);
    }
}
