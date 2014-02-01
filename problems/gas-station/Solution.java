public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ind = 0;
        int gasSum = 0;
        int costSum = 0;
        boolean completed = false;
        while (!completed) {
            for (int i = 0; i < gas.length; i++) {
                if (i + ind == gas.length) {
                    completed = true;
                    ind -= gas.length;
                }
                gasSum += gas[i + ind];
                costSum += cost[i + ind];
                if (gasSum < costSum) {
                    gasSum = 0;
                    costSum = 0;
                    ind = i + ind + 1;
                    break;
                }
            }
            if (gasSum != 0)
                return (ind + gas.length) % gas.length;
        }
        return -1;
    }
}