import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] alphabet = new char[26];
        for (int i=0; i<alphabet.length; i++){
            alphabet[i] = (char)(i+97);
        }
        while (true) {
            String line = br.readLine();
            if (line.equals("end") ) break;
            boolean flag = true;
            String vowels = "aeiou";
            if (!line.matches(".*[aeiou].*")) flag = false;
            int consecutiveVowels = 0;
            int consecutiveConsonants = 0;
            char prevChar = '\0';
            for (char c : line.toCharArray()){
                if (c == prevChar && c != 'e' && c != 'o') {
                    flag = false;
                }
                if (vowels.indexOf(c) != -1){
                    consecutiveVowels++;
                    consecutiveConsonants = 0;
                } else {
                    consecutiveVowels = 0;
                    consecutiveConsonants ++;
                }
                if (consecutiveConsonants >= 3 || consecutiveVowels >= 3){
                    flag = false;
                }
                prevChar = c;
            }

            if (flag) {
                sb.append("<" + line + "> is acceptable.").append("\n");
            } else {
                sb.append("<" + line + "> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }
}