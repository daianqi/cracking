/*
Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n-pairs of parentheses.
*/

import java.lang.String;
import java.lang.System;

public class cracking9_06 {
    
    public static void printAllCombinationHelper(int pairs, int left, int right, String str) {
        if(left == pairs) {
            if(right == pairs)
                System.out.println(str);
            else {
                while(right < pairs) {
                    right ++;
                    str += ')';
                }
                System.out.println(str);
            }
        } else {
            if(left == right) {
                str += '(';
                left++;
                printAllCombinationHelper(pairs,left,right,str);
            } else {
                String str1 = str + '(';
                int left1 = left + 1;
                String str2 = str + ')';
                int right1 = right + 1;
                printAllCombinationHelper(pairs,left1,right,str1);
                printAllCombinationHelper(pairs,left,right1,str2);
            }
        }
    }

    public static void printAllCombination(int pairs) {
        if(pairs == 0)
            return;
        int leftparenthese = 1;
        int rightparenthese = 0;
        String str = "(";
        printAllCombinationHelper(pairs, leftparenthese, rightparenthese, str);
    }

    public static void main(String[] args) {
        int pairs = 3;
        printAllCombination(pairs);
    }
}
