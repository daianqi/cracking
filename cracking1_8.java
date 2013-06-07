/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write
code to check if s2 is a rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
*/

public class cracking1_8 {
    public static boolean isRotation(String str1, String str2) {
        if(str1.length() == str2.length() && str1.length()>0) {
            String str1str1 = str1 + str1;
            return isSubstring(str1str1,str2))
        }
        else
            return false;
    }
}