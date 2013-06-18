/*
Write a function to determine the number of bits required to convert integer A to integer B
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;

public class cracking5_5 {

    public static int stupidCountBit (int a, int b) {
        int c = a^b;
        int count = 0;
        for(;c!=0;c = c >> 1) {
            if((c&1) != 0)
                count++;
        }
        return count;
    }

    //c&(c-1) clear the least significant bit in c
    public static int hardCountBit(int a, int b) {
        int c = a^b;
        int count = 0;
        for(;c!=0;c = c&(c-1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(readBuffer.readLine());
        int b = Integer.parseInt(readBuffer.readLine());

        System.out.println("# of bits needed: " + stupidCountBit(a, b));
        System.out.println("# of bits needed: " + hardCountBit(a, b));
    }
}