class Solution {
    public static void main(String[] args) {
        
    }
    
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left <= right) {
            int currentWater = (right - left) * Math.min(height[left], height[right]);
            if (currentWater > max) max = currentWater;

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }       
        
        }

        return max;
    }
}