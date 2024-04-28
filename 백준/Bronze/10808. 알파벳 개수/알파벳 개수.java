import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] alphabet = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); i++){
            alphabet[word.charAt(i) - 'a']++;
        }
        for (int i=0; i<alphabet.length; i++){
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb);
    }
}