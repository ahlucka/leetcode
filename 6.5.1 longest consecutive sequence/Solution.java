class Solution {
    public static void main(String[] args) {

    }
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int currentCount = 1;
        int maxCount = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) continue;

            if (nums[i] == nums[i - 1]) continue;

            if (i == 0 || nums[i - 1] == nums[i] - 1) currentCount++; 
            
            else {
                if (maxCount < currentCount) maxCount = currentCount;
                currentCount = 1;
            }

            if (maxCount < currentCount) {
                maxCount = currentCount;
            }

        }

        return maxCount;

    }
}