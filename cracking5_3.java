/*
Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their
binary representation.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;

public class cracking5_3 {
    /*
    Smallest of larger: set the right-most non-trailing(non-ending) 0 to 1, and re-organize all 0s and 1s to the right of the
    flipping one, so that all 1s are to the right(make smallest)
    */

    /*
    Largest of smaller: set the right-most non-trailing(non-ending) 1 to 0, and re-organize all 0s and 1s to the right of the
    flipping one, so that all 1s are to the left(make largest)
    */

    public static int getBit(int N, int pos) {
        return (N & (1<<pos))==0 ? 0: 1;
    }

    public static int setBit(int N, int pos) {
        return (N | (1<<pos));
    }

    public static int clearBit(int N, int pos) {
        return (N & ~(1<<pos));
    }

    //compute the rightmost non-trailing 0/1' position
    public static int computeNonTrailing(int N, int zeroOrOne) {
        if(zeroOrOne != 1 && zeroOrOne != 0)
            return -1;
        boolean flag = false;
        int bitpos = 0;
        if(zeroOrOne == 1) {
            while(bitpos < 32) {
                if(getBit(N,bitpos) == 0 && flag == false) {
                    flag = true;
                }
                if(getBit(N,bitpos) == 1 && flag == true) {
                    return bitpos;
                }
                bitpos ++;
            }
            return -1;
        }
        else {
            while(bitpos < 32) {
                if(getBit(N,bitpos) == 1 && flag == false) {
                    flag = true;
                }
                if(getBit(N,bitpos) == 0 && flag == true) {
                    return bitpos;
                }
                bitpos++;
            }
            return -1;
        }
    }
    //compute the # of 0s to the right of the non-trailing
    public static int computeC0(int N, int nonTrailingPos) {
        int count = 0;
        for(int i = 0;i<nonTrailingPos;i++) {
            if(getBit(N,i) == 0)
                count ++;
        }
        return count;
    }
    //compute the # of 1s to the right of the non-trailing
    public static int computeC1(int N, int nonTrailingPos) {
        int count = 0;
        for(int i = 0;i<nonTrailingPos;i++) {
            if(getBit(N,i) == 1)
                count ++;
        }
        return count;
    }

    public static int smallestLarger(int N) {
        int nonTrailingPos = computeNonTrailing(N,0);
        int c0 = computeC0(N,nonTrailingPos);
        int c1 = computeC1(N,nonTrailingPos);

        //flip nonTrailingPos 0 to 1
        N = setBit(N,nonTrailingPos);

        //clear right part of nonTrailingPos bit
        N = N & ~((1<<nonTrailingPos)-1);

        //set c1-1 1s to the right most
        N += (1<<(c1-1))-1;

        return N;
    }

    public static int largestSmaller(int N) {
        int nonTrailingPos = computeNonTrailing(N,1);
        int c0 = computeC0(N,nonTrailingPos);
        int c1 = computeC1(N,nonTrailingPos);

        //flip nonTrailingPos 1 to 0
        N = clearBit(N,nonTrailingPos);

        //clear right part of nonTrailingPos bit
        N = N & ~((1<<nonTrailingPos)-1);

        //set c1+1 1s to the left most
        int mask = (1<<(c1+1)) - 1;
        N |= mask << (c0 - 1); //stupid mind didn't figure it out.....GEE

        return N;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(readBuffer.readLine());

        System.out.println("smallestLarger = " + smallestLarger(N));
        System.out.println("largestSmaller = " + largestSmaller(N));
    }
}

//StringBuilder.append
