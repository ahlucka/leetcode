class Solution {
    public static void main(String[] args) {
        
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> listOfNums = new HashSet<>();

        for (int num : nums) {
            if (listOfNums.contains(num)) return true;
            listOfNums.add(num);
        }
        
        return false;
    }
}