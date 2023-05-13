class Solution {
    public int solution(String number) {
        return number.chars().map(Character::getNumericValue).sum() % 9;
    }
}