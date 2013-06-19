/*
A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte. The screen has width w, where w is divisible by 8. The height of the screen, of course, can be derived from the length of the array and the width. Implement a function drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) which draws a horizontal line from (x1,y) to (x2,y).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.util.ArrayList;

public class cracking5_8 {
    public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1%8;
        int first_full_byte = x1/8;
        if(start_offset != 0)
            first_full_byte ++; //the next is full

        int end_offset = x2%8;
        int last_full_byte = x2/8;
        if(end_offset != 7) {  //stupid mind cant understand this
            last_full_byte --;
        }

        //set full bytes
        for(int b = first_full_byte;b < last_full_byte;b++) {
            screen[(width/8)*y+b] = (byte) 0xFF;
        }

        //create masks
        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset+1)) //stupid mind cant understand

        //set fractional part
        if(x1/8 == x2/8) {
            byte mask = (byte) (start_mask & end_mask);
            screen[(width/8)*y+x/8] |= mask;
        } else {
            if(start_offset != 0) {
                int byte_number = (width/8)*y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if(end_offset != 0) {
                int byte_number = (width/8)*y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

    public static void main(String[] args) {
        int n = (int) 2.8;
        System.out.println(n);
    }
}
