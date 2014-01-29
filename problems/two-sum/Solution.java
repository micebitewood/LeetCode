public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(target - num)) {
                return new int[] {map.get(target - num), i + 1};
            }
            map.put(num, i + 1);
        }
        return null;
    }
}