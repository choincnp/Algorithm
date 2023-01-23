class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int gcd = getGCD(num1,num2);
        int lcm = getLCM(num1, num2, gcd);
        denum1 *= lcm/num1;
        denum2 *= lcm/num2;
        int gcd2 = getGCD(denum1+denum2, lcm);
        int[] answer = {((denum1+denum2)/gcd2), (lcm/gcd2)};
        return answer;
    }
    public static int getGCD(int a, int b){
        while (b != 0)
        {int r = (int)a%b;
        a = b;
        b = r;}
        return a;                               
    }
    public static int getLCM(int a, int b, int gcd){return a*b/gcd;}
}
