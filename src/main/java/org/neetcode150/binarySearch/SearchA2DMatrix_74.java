package org.neetcode150.binarySearch;

public class SearchA2DMatrix_74 {
    /*
        Problem Statement: Binary search in 2D matrix
        Intuition: calculate index row = mid / n
        Time Complexity: O(log(m*n))
        Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            int row = mid / m;
            int col = mid % m;

            if(target < matrix[row][col]){
                right = mid - 1;
            }else if(target > matrix[row][col]){
                left = mid + 1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix_74 obj = new SearchA2DMatrix_74();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        System.out.println(obj.searchMatrix(matrix, target)); // Output: true
    }

}
