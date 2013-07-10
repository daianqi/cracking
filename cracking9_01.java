/*
A child is running up a staircase with n steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method
to count how many possible ways the child can run up the stairs.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.System;

public class cracking9_01 {

    public static int numOfWays(int N) {
        if(N >= 3)
            return numOfWays(N-3) + numOfWays(N-2) + numOfWays(N-1);
        else if(N == 2)
            return 2;
        else  //0 or 1
            return 1;
    }

    public static int bookNumOfWays (int N) {
        if(N < 0)
            return 0;
        else if(N == 0)
            return 1;
        else return bookNumOfWays(N-3) + bookNumOfWays(N-2) + bookNumOfWays(N-1);
    }

    public static int dynamicNumOfWays (int N, int[] map) {
        if(N < 0)
            return 0;
        else if(N == 0)
            return 1;
        else if(map[N] > 0)
            return map[N];
        else {
            map[N] = dynamicNumOfWays(N-1,map)+dynamicNumOfWays(N-2,map)+dynamicNumOfWays(N-3,map);
            return map[N];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(readBuffer.readLine());
        int[] map = new int[10000];

        System.out.println("# of possible ways(dynamic) : " + dynamicNumOfWays(N, map));
        System.out.println("# of possible ways : " + numOfWays(N));
        System.out.println("# of possible ways(book) : " + bookNumOfWays(N));
    }
}