/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/

//dumb doing one: character != alphabet
//import java.io.*;
//
//public class cracking1_1 {
//     public static void main(String[] args) throws IOException{
//         int i;
//         boolean[] alpha = new boolean[26];
//         BufferedReader bufferedInput= new BufferedReader(new InputStreamReader(System.in));
//         String input = bufferedInput.readLine();
//
//         for(i = 0;i<input.length();i++) {
//             if(alpha[input.charAt(i)-'a'] == true) {
//             System.out.println("There is duplicated characters in the string!");
//             break;
//         }
//         else
//             alpha[input.charAt(i)-'a'] = true;
//         }
//         if(i == input.length())
//             System.out.println("All unique!");
//     }
//}


//slightly change dumb doing to ACSII string
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class cracking1_1 {
    public static boolean checkDuplicate(String str) {
        if(str.length()>256) return false;
        boolean[] check_set = new boolean[256];

        for(int i = 0;i<str.length();i++) {
            int val = str.charAt(i);
            if(check_set[val] == true)
                return false;
            else
                check_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = inputReader.readLine();
        if(checkDuplicate(inputLine))
            System.out.println("All Unique!");
        else
            System.out.println("There are duplicated characters!");
    }
}

//suppose 26 alphabetic using bit manipulation
//import java.io.IOException;
//
//public class cracking1_1 {
//    public static boolean checkDuplicate(String str){
//        int checker = 0;
//        for(int i = 0;i<str.length();i++) {
//            int val = str.charAt(i)-'a';
//            if((checker & (1<<val)) >0)
//                return false;
//            else
//                checker |= (1<<val);
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
//        String inputLine = inputReader.readLine();
//        if(checkDuplicate(inputLine))
//            System.out.println("All Unique!");
//        else
//            System.out.println("There are duplicated characters!");
//    }
//}



































