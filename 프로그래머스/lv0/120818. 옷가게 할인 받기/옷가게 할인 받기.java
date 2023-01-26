class Solution {
    public int solution(int price) {
        return price>=500000? price*80/100 : price>=300000? price*9/10 : price>=100000? price*95/100 : price;
    }
}