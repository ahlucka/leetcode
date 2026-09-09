class Solution {
    public static void main(String[] args) {
        
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                queue.add(num);
                queue.poll();
            }
        }

        return queue.peek();
    }
}