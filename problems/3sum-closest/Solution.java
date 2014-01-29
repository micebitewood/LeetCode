public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length <= 2)
            return 0;
        int min = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int val = num[i] + num[left] + num[right];
                if (Math.abs(val - target) < Math.abs(min - target)) {
                    min = val;
                }
                if (val < target)
                    left++;
                else if (val > target)
                    right--;
                else
                    return val;
            }
        }
        return min;
    }
}