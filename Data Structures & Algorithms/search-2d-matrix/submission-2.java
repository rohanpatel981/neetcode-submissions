class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int N = row * col;
        int low = 0, high = N - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int r = mid / col;
            int c = mid % col;

            if (target == matrix[r][c])
                return true;
            else if (matrix[r][c] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
}
