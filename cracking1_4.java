/*
Write a method to replace all spaces in a string with ‘%20’. You may assume that the string has sufficient space at the end
of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if implemented
in Java, please use a character array so that you can perform this operation in place.)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class cracking1_4 {
    public static int getTrueLength(String str) {
        int trueLength = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i) == ' ')
                trueLength += 3;
            else
                trueLength += 1;
        }
        return trueLength;
    }

    public static String replace(String str, int trueLength) {
        char[] result = new char[trueLength];
        int pos = trueLength - 1;
        for(int i = str.length()-1;i>=0;i--) {
            if(str.charAt(i) == ' ') {
                result[pos--] = '0';
                result[pos--] = '2';
                result[pos--] = '%';
            }
            else {
                result[pos--] = str.charAt(i);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = inputReader.readLine();
        int inputLength = getTrueLength(inputLine);

        System.out.println(replace(inputLine, inputLength));
    }
}
//suppose given enough char array: str[newLength] = '\0'
