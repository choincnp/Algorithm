class Solution {
    public int solution(int[] num_list) {
        StringBuilder sbOdd = new StringBuilder();
        StringBuilder sbEven = new StringBuilder();
        for (int i=0; i<num_list.length; i++){
            if (num_list[i]%2==0) sbOdd.append(num_list[i]);
            else sbEven.append(num_list[i]);
        }
        int odd = Integer.parseInt(sbOdd.toString());
        int even = Integer.parseInt(sbEven.toString());
        return odd+even;
    }
}