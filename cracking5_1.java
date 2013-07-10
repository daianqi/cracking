/*
You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N such that M
starts at bit j and ends at bit i. You can assume that the bits j through i have enough spave to fit all of M. That is, if
M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for example, have j =3 and i = 2,
because M could not fully fit between bit 3 and bit 2.
EXAMPLE:
Input: N = 100 0000 0000, M = 1 0011, i = 2, j = 6
Output: N = 100 0100 1100
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.System;

public class cracking5_1 {
    public static int mix(int N, int M, int small, int big) {
        for(int i = small; i<big;i++) {
            int mask = 1<<i;
            N &= ~mask;
        }
        return N | (M<<small);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(readBuffer.readLine());
        int M = Integer.parseInt(readBuffer.readLine());
        int small = Integer.parseInt(readBuffer.readLine());
        int big = Integer.parseInt(readBuffer.readLine());

        System.out.println(mix(N,M,small,big));
    }
}
