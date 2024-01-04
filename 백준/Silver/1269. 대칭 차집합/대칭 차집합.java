import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (N-->0){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while (M-->0){
            setB.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> setC = new HashSet<>();
        setC.addAll(setA);
        setC.addAll(setB);
        setB.retainAll(setA);
        System.out.println(setC.size() - setB.size());
    }
}