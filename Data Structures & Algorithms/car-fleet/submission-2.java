class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[speed.length][2];
        int res = 1;

        for (int i = 0; i < speed.length; ++i) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i]; 
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        double currTime = currTime = (target - pair[0][0])/pair[0][1];

        for (int i = 1; i < speed.length; ++i) {
            if ((double) (target - pair[i][0])/pair[i][1] > currTime) {
                currTime = (double)(target - pair[i][0])/pair[i][1];
                res++;
            }
        }

        return res;
    }
}
