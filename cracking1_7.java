/*
Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
*/

public class cracking1_7 {
    
    public static void setZero (int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[0].length;j++) {
                if(row[i] == true || column[j] == true)
                    matrix[i][j] = 0;
            }
        }
    }

}
