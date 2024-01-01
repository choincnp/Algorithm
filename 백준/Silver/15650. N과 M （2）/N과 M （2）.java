import java.util.Scanner;

public class Main{
    static int[] array;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[M];
        backtracking(1, 0);
        System.out.print(sb);
    }
    static void backtracking(int num, int length){
        if (length == M){
            for (int i : array){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = num; i<=N; i++){
            array[length] = i;
            backtracking(i+1, length+1);
        }
    }
}