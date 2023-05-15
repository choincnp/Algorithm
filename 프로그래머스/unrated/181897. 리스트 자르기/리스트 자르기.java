import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>();
        switch(n){
            case 1:
                IntStream
                    .rangeClosed(0,slicer[1])
                    .forEach(i -> list.add(num_list[i]));
                break;
            case 2:
                IntStream
                    .rangeClosed(slicer[0],num_list.length-1)
                    .forEach(i -> list.add(num_list[i]));
                break;
            case 3:
                IntStream
                    .rangeClosed(slicer[0], slicer[1])
                    .forEach(i -> list.add(num_list[i]));
                break;
            case 4:
                IntStream
                    .iterate(slicer[0], i -> i + slicer[2])
                    .limit((slicer[1] - slicer[0]) / slicer[2] + 1)
                    .forEach(t -> list.add(num_list[t]));
                break;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}