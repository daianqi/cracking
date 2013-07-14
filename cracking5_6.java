/*
Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped,
bit 2 and bit 3 are swapped, and so on).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;

public class cracking5_6 {
    //mask the number with 10101010 to get the odd bit and >> 1 to move to even position
    //mask the number with 01010101 to get the even bit and << 1 to move to odd position
    public static int swap (int n) {
        return ((n&0xaaaaaaaa)>>1) | ((n&0x55555555)<<1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(readBuffer.readLine());

        System.out.println("the number after swap: " + swap(a));
    }
}

