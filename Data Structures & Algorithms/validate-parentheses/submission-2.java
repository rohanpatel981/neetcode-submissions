class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) { //s="([){]}"
            if (!stack.isEmpty()) {
                switch (x) {
                    case ']' : {
                        if (stack.peek() != '[')
                            return false;
                        stack.pop();
                        break;
                    }
                    case '}' : {
                        if (stack.peek() != '{')
                            return false;
                        stack.pop();
                        break;
                    }
                    case ')' : {
                        if (stack.peek() != '(')
                            return false;
                        stack.pop();
                        break;
                    }
                    default :
                        stack.push(x);
                }
            } else
                stack.push(x);
        }

        return stack.isEmpty();
    }
}
