class Solution {
    public static void main(String[] args) {
        
    }
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ints = new HashMap<Integer, Integer>();
        int[] vals = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int completement = target - nums[i];
            
            if (ints.containsKey(completement)) {
                vals[0] = i;
                vals[1] = ints.get(completement);
                break;
            }

            ints.put(nums[i], i);
        }

    return vals;

    }
}