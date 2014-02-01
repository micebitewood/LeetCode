public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        for (int a : A) {
            int xthree = ~(a & twos);
            twos ^= (ones & a);
            ones ^= a;
            twos &= xthree;
            ones &= xthree;
        }
        return ones;
    }
}