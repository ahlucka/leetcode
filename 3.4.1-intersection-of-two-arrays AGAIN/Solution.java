import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        
        set1.retainAll(set2);

        int[] result = new int[(set1.size())];
        int i = 0;
        for (int j : set1) {
            result[i++] = j;
        }

        return result;
    }
}