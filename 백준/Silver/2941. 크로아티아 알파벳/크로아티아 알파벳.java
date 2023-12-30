import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String[] croatian = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i=0; i<croatian.length; i++){
            word = word.replace(croatian[i], "a");
        }
        System.out.println(word.length());
    }
}