import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int i=0; i<caseNum; i++){
            int bonus = 1, answer = 0;
            String s = sc.next();
            for (int j=0; j<s.length(); j++){
                if (s.charAt(j)=='O'){
                    answer += bonus;
                    bonus++;
                }
                else bonus = 1;
            }
            System.out.println(answer);
        }

    }
}