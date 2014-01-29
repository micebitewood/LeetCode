public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        for (int a: A) {
            twos |= (ones & a);
            ones ^= a;
            int xthree = ~(ones & twos);
            twos &= xthree;
            ones &= xthree;
        }
        return ones;
    }
}