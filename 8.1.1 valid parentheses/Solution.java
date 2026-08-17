class Solution {
    public static void main(String[] args) {
        
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }
            
            if (s.charAt(i) == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            
            if (s.charAt(i) == '}') {
                if (stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(s.charAt(i));

            }
            
        return stack.isEmpty();

    }
}