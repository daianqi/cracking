/*
Given an M*N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
*/

import java.lang.System;

public class cracking11_6 {
    
    public static boolean findEleHelp(int ele,int[][] array,int x,int y) {
        if(x>=array.length || y<0)
            return false;
        if(ele == array[x][y]) {
            System.out.println("("+x+","+y+")");
            return true;
        }
        else if (ele >array[x][y])
            return findEleHelp(ele, array, x+1, y);
        else
            return findEleHelp(ele, array, x, y-1);
    }

    //the trick is go two different direction with ascending and descending order
    public static boolean findEle (int ele, int[][] array) {
        return findEleHelp(ele,array,0,array[0].length-1);
    }

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0][0] = 15;
        array[0][1] = 20;
        array[0][2] = 40;
        array[0][3] = 85;

        array[1][0] = 20;
        array[1][1] = 35;
        array[1][2] = 80;
        array[1][3] = 95;

        array[2][0] = 30;
        array[2][1] = 55;
        array[2][2] = 95;
        array[2][3] = 105;

        array[3][0] = 40;
        array[3][1] = 80;
        array[3][2] = 100;
        array[3][3] = 120;

        System.out.println(findEle(55,array)?"YES":"NO");
    }
}
