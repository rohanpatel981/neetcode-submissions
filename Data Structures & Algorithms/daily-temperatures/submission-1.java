class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int N = nums.length, _max = 0;
        int[] res = new int[N];
        Stack<int[]> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek()[1] - i;
            }
            
            stack.push(new int[] {nums[i], i});
        }

        return res;
    }
}

/*
30,38,30,36,35,40,28
stack = 38, 40
*/
