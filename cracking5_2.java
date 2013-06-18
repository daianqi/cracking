/*
Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation. If the number
cannot be represented accurately in binary with at most 32 characters, print "ERROR".
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;

public class cracking5_2 {
    public static ArrayList<Integer> decimalToBinary(double N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        while(N != 0) {
            if(count > 32) return null;
            N = N * 2;
            if( N >= 1) {
                result.add(1);
                N -= 1;
            } else {
                result.add(0);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(readBuffer.readLine());

        ArrayList<Integer> result = decimalToBinary(N);
        if(result == null)
            System.out.println("ERROR");
        else {
            System.out.print("0.");
            for(int i = 0;i<result.size();i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
}

//StringBuilder.append