class Solution {
    public boolean isValid(String s) {
        char[] list = s.toCharArray(); 
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : list) {
            boolean isOpen = (c == '(') || (c =='{') || (c == '['); 
            if (isOpen) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; 
                if (isMatch(stack.pop(), c) == false) return false; 
            }
        }
        if (stack.isEmpty()) return true;
        return false; 
    }

    private boolean isMatch(char open, char close) {
        boolean m = true; 
        if (open == '(' && close != ')') m =  false;
        if (open == '{' && close != '}') m =  false;
        if (open == '[' && close != ']') m =  false;
        return m; 
    }
}
