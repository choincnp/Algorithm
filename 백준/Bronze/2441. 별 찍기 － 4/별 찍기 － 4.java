import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0; i<num; i++) { 
            for(int j=num-i; j<num; j++) {
                System.out.print(" ");     
            }         
            for(int k=i; k<num; k++) {
                System.out.print("*");
            }            
            System.out.println();            
        }
    }
}
