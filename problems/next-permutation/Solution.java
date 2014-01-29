public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null)
            return;
        int last = num.length - 1;
        if (last == 0)
            return;
        while (last > 0) {
            if (num[last - 1] >= num[last])
                last--;
            else
                break;
        }
        if (last == 0) {
            Arrays.sort(num);
            return;
        } else if (last == num.length - 1) {
            int temp = num[last];
            num[last] = num[last - 1];
            num[last - 1] = temp;
            return;
        }
        int n = num[last - 1];
        int second = last;
        while (second < num.length) {
            if (num[second] > n) {
                second++;
            } else
                break;
        }
        second--;
        int temp = num[last - 1];
        num[last - 1] = num[second];
        num[second] = temp;
        for (int i = last; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[i]) {
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
    }
}