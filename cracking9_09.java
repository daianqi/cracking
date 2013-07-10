/*
Write an algorithm to print all ways of arranging eight queens on an 8*8 chess board so that none of them share the same row,
 column ot diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
*/

import java.lang.Integer;
import java.lang.Math;
import java.lang.System;
import java.util.ArrayList;

public class cracking9_09 {
    public static boolean checkValid(Integer[] columns, int row, int col) {
        for(int row2 = 0; row2< row; row2++) {
            int col2 = columns[row2];
            if(col == col2)
                return false;
            if(Math.abs(row-row2) == Math.abs(col-col2))    //genuis for diagonal
                return false;
        }
        return true;
    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if(row == columns.length) {
            results.add(columns.clone());   //end
        } else {
            for(int col = 0;col<columns.length;col++) {
                if(checkValid(columns, row, col)) {
                    columns[row] = col;      //put queen
                    placeQueens(row+1, columns, results);
                }
            }
        }
    }

    public static void print(ArrayList<Integer[]> results) {
        for(Integer[] array : results) {
            for(int i = 0; i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int GRID_SIZE = 8;
        Integer[] columns = new Integer[GRID_SIZE];
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        placeQueens(0, columns, results);
        print(results);
    }
}