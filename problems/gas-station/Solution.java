public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = sum(gas);
        int totalCost = sum(cost);
        if (totalGas < totalCost)
            return -1;
        int i = 0;
        while (i < gas.length) {
            totalGas = 0;
            totalCost = 0;
            for (int j = 0; j < gas.length; j++) {
                int ind = (i + j) % gas.length;
                totalGas += gas[ind];
                totalCost += cost[ind];
                if (totalGas < totalCost) {
                    if (ind + 1 < i)
                        return -1;
                    i = ind + 1;
                    break;
                }
            }
            if (totalGas == sum(gas))
                return i;
        }
        return -1;
    }
    
    private int sum(int[] arr) {
        int res = 0;
        for (int num: arr) {
            res += num;
        }
        return res;
    }
}