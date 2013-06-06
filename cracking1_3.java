/*
Given two strings, write a method to decide if one is a permutation of the other.
*/
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cracking1_3 {
    public static boolean checkPermutation(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        int[] check_set = new int[256];
        for(int i = 0;i<str1.length();i++) {
            check_set[str1.charAt(i)]++;
        }
        for(int j = 0;j<str2.length();j++) {
            if(check_set[str2.charAt(j)] == 0)
                return false;
            else
                check_set[str2.charAt(j)] --;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = inputReader.readLine();
        String str2 = inputReader.readLine();

        if(checkPermutation(str1, str2))
            System.out.println("They are permutation of each other!");
        else
            System.out.println("They aren't");
    }
}

//String -> char array: String s; char[] content = s.toCharArray();
//char array -> String: new String(content);
