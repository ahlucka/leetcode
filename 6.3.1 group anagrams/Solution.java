class Solution {
    public static void main(String[] args) {
    
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> letterCounts = new HashMap<>();
        
        for (String word : strs) {
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(count);
            letterCounts.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        
        }
        
        return new ArrayList<>(letterCounts.values());
    
    }
}