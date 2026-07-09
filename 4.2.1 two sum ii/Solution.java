class Solution {
    public static void main(String[] args) {
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[(2)];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int current = numbers[left] + numbers[right];

            if (current == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (current < target) {
                left++;
            } else right--;
        }

        result[0] = -1;
        result[1] = -1;

        return result;
    }
}