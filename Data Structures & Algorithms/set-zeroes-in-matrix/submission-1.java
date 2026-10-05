// O(1)

// LC-73

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows= matrix.length;
        int cols= matrix[0].length;

        // extra var for 1st row marking
        boolean rowZero= false;

        // check which rows and cols need to be zero

        for(int r=0; r < rows; r++) {
            for(int c=0; c < cols; c++) {
                if(matrix[r][c]==0) {
                    matrix[0][c]=0;

                    if(r > 0) {
                        matrix[r][0]=0; // for 2nd row onwards
                    }
                    else{
                        rowZero= true;
                    }
                }
            }
        }

        // start from 1st row and 1st col

        for(int r=1; r<rows; r++ ){
            for(int c=1; c<cols; c++) {
                if(matrix[r][0]==0 || matrix[0][c]==0) {
                    matrix[r][c]=0;
                }
            }
        }

        // check for 1st col
        if(matrix[0][0]==0) {
            //set first col to 0--> iterate thru every row in 0th col
            for(int r=0; r<rows; r++) {
                matrix[r][0]=0;
            }
        }

        if(rowZero) {
            for(int c=0; c<cols; c++) {
                matrix[0][c] =0;
            }
        }    
    }
}