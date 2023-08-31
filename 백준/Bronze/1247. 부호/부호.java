import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<3; i++){
            int k = sc.nextInt();
            BigInteger n = BigInteger.ZERO;
            for (int j=0; j<k; j++){
                n = n.add(sc.nextBigInteger());
            }
            System.out.println(sign(n));
        }
    }

    static char sign(BigInteger i){
        return i.compareTo(BigInteger.ZERO) > 0 ? '+' : (i.compareTo(BigInteger.ZERO) < 0 ? '-' : '0');
    }
}
