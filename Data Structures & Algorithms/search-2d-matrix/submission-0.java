class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // better-> m * log(n) --> binary search on all rows
        // next better--> binary search on cols then again search on selected row--> O(logm + logn)
        // optimal--> cause it is sorted--> O(log(m*n))

        int rows= matrix.length;
        int cols= matrix[0].length;

        int left=0; 
        int right= rows*cols-1; // total elements in the 1d array

        while(left <=  right) {
            //  WRONG--> int mid= (left+(right-left)) /2;--> BECOMES RIGHT/2

            int mid= left +(right-left) /2;

            int r= mid/cols;
            int c= mid%cols;
            if(matrix[r][c] == target){
                return true;
            }
            else if(target > matrix[r][c]) {
                left= mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return false;
    }
}
