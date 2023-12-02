import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            int right = st.nextToken().charAt(0) - 'A' + 1;
            arr[root].add(new Node(left, right));
        }
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb);

    }
    static void preorder(int i){
        for (Node n : arr[i]){
            int left = n.left;
            int right = n.right;
            sb.append((char)(i+'A'-1));
            if (left != -18) preorder(left);
            if (right != -18) preorder(right);
        }
    }
    static void inorder(int i){
        for (Node n : arr[i]){
            int left = n.left;
            int right = n.right;
            if (left != -18) inorder(left);
            sb.append((char)(i+'A'-1));
            if (right != -18) inorder(right);
        }
    }
    static void postorder(int i){
        for (Node n : arr[i]){
            int left = n.left;
            int right = n.right;
            if (left != -18) postorder(left);
            if (right != -18) postorder(right);
            sb.append((char)(i+'A'-1));
        }
    }
    static class Node{
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}