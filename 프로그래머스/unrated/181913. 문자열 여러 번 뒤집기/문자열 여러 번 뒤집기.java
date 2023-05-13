class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int i=0; i<queries.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(my_string.substring(queries[i][0], queries[i][1]+1));
            sb.reverse();
            String prefix = queries[i][0]==0? "" : my_string.substring(0,queries[i][0]);
            String suffix = queries[i][1]==my_string.length()-1? "" : my_string.substring(queries[i][1]+1);
            my_string = prefix + sb.toString() + suffix;
        }
        return my_string;
    }
}