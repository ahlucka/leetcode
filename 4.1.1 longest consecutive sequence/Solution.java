import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> vals = new HashSet<>();

        for (int i : nums) {
            vals.add(i);
        }
        
        int longestStreak = 0;

        for (int i : vals) {
            if (!vals.contains(i - 1)) {
                int currentNum = i;
                int currentStreak = 1;
                
                while(vals.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}