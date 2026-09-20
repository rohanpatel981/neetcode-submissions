class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) { // tokens=["4","13","5","/","+"]
            if (s.length() == 1
                && (s.charAt(0) == '+' || s.charAt(0) == '/' || s.charAt(0) == '-'
                    || s.charAt(0) == '*')) {
                char c = s.charAt(0);
                int a = stack.pop(); // 2
                int b = stack.pop(); // 4
                if (c == '*')
                    stack.push(b * a);
                if (c == '-')
                    stack.push(b - a);
                if (c == '/')
                    stack.push(b / a);
                if (c == '+')
                    stack.push(b + a);
            } else
                stack.push(Integer.parseInt(s)); // 5, 13, 4
        }

        return stack.pop();
    }
}
/*
 */
