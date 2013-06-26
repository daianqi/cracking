/*
Write a method to compute all permutations of a string.
*/

import java.lang.String;
import java.lang.System;
import java.util.ArrayList;

public class cracking9_05 {
    public static String insertCharAt(String word, char first, int pos) {
        String start = word.substring(0,pos);
        String end = word.substring(pos);
        return start + first + end;  //genuis
    }

    public static ArrayList<String> book(String str) {
        if(str == null)
            return null;
        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);    //keep track of the first char
        String remainder = str.substring(1);  //get rid of the first char

        ArrayList<String> words = book(remainder);    //recursive

        for(String word : words) {            //insert into every possible pos
            for(int j = 0;j<=word.length();j++) {
                String s = insertCharAt(word,first,j);
                permutations.add(s);
            }
        }

        return permutations;
    }

    public static ArrayList<String> printHelper(char[] charArray, int index) {
        ArrayList<String> newArray;
        if(index == charArray.length - 1) {
            newArray = new ArrayList<String>();
            char[] newCharArray = new char[1];
            newCharArray[0] = charArray[index];
//            System.out.println(new String(newCharArray));
            newArray.add(new String(newCharArray));
            return newArray;
        } else {
            newArray = printHelper(charArray, index + 1);
            ArrayList<String> output = new ArrayList<String>();
            for(String str : newArray) {
//                System.out.println(str);
                int pos = 0;
                while(pos <= str.length()) {
                    char[] tmp = new char[str.length()+1];
                    for(int i = 0,j=0;i<str.length()+1;i++) {
                        if(i == pos)
                            tmp[i] = charArray[index];
                        else {
                            tmp[i] = str.charAt(j);
                            j++;
                        }
                    }
//                        System.out.println(tmp.toString());
                    output.add(new String(tmp));
                    pos++;
                }
            }
            return output;

        }
    }

    public static void print(ArrayList<String> output) {
        for(String str : output) {
            System.out.print(str);
            System.out.println();
        }
        System.out.println();

    }

    public static void printAllPermutation(String input) {
        char[] charArray = input.toCharArray();
        ArrayList<String> output = printHelper(charArray,0);
        print(output);
    }

    public static void main(String[] args) {
        String input = "abcd";
        printAllPermutation(input);
        print(book(input));
    }
}
