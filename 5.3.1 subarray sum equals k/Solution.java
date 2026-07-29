class Solution {
    public static void main(String[] args) {
        
    }
    
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            count += sumCount.getOrDefault(currentSum - k, 0);
            sumCount.merge(currentSum, 1, Integer::sum);
        }
        return count;
    }
}