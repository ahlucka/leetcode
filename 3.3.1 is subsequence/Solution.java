class Solution {
    public static void main(String[] args) {
        
    }
    
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        
        int sPos = 0;

        for (int i = 0; i < t.length(); i++) {
            if (sPos == s.length()) break;
            if (t.charAt(i) == (s.charAt(sPos))) {
                sPos++;
            }
        }
        return sPos == s.length();
    }
}