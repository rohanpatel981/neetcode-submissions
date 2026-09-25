class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ++i) {
            int left = 0, right = matrix[0].length - 1;

            if (matrix[i][left] <= target && matrix[i][right] >= target) {
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] < target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }

        return false;
    }
}
