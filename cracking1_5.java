/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabccccaaa
would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return
the original string.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Character;

//dumb doing: use / and % to get digits of an interger, and put it in char array
//didn't consider empty string input
//public class cracking1_5 {
//    public static int computeLength(String str) {
//        int result = 0;
//        char tmp = str.charAt(0);
//        int count = 1;
//        for(int i = 1;i < str.length();i++) {
//            if(str.charAt(i) != tmp) {
//                result ++;
//                while(count > 0) {
//                    result ++;
//                    count /= 10;
//                }
//                tmp = str.charAt(i);
//                count = 1;
//            }
//            else {
//                count ++;
//            }
//        }
//        result += 2;
//        return result;
//    }
//
//    public static String compress(String str, int cLength) {
//        char tmp = str.charAt(str.length()-1);
//        int count = 1;
//        char[] result = new char[cLength];
//        int pos = cLength - 1;
//        for(int i = str.length()-2; i>=0;i--) {
//            if(str.charAt(i) == tmp) {
//                count ++;
//            }
//            else {
//                while(count > 0){
//                    result[pos--] = (char)(count%10+'0');
//                    count /= 10;
//                }
//                result[pos--] = tmp;
//                tmp = str.charAt(i);
//                count = 1;
//            }
//        }
//        while(count > 0){
//            result[pos--] = (char)(count%10+'0');
//            count /= 10;
//        }
//        result[pos--] = tmp;
//
//        return new String(result);
//    }
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
//        String inputLine = inputReader.readLine();
//        int compressedLength = computeLength(inputLine);
//
//        if(compressedLength >= inputLine.length())
//            System.out.println(inputLine);
//        else
//            System.out.println(compress(inputLine, compressedLength));
//    }
//}

//slightly change dumb doing using String.valueOf(i).length() or String.valueOf(i).toCharArray()
public class cracking1_5 {
    public static int computeLength(String str) {
        if(str == null || str.isEmpty()) return 0;
        int size = 0;
        int count = 1;
        char tmp = str.charAt(0);
        for(int i = 1;i<str.length();i++) {
            if(str.charAt(i) == tmp) {
                count ++;
            }
            else {
                tmp = str.charAt(i);
                size += 1+ String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1+ String.valueOf(count).length();
        return size;
    }

    public static String compress(String str, int cLength) {
        char tmp = str.charAt(0);
        int count = 1;
        char[] result = new char[cLength];
        int pos = 0;
        for(int i = 1;i<str.length();i++) {
            if(str.charAt(i) == tmp)
                count++;
            else {
                result[pos++] = tmp;
                tmp = str.charAt(i);
                char[] tmpCharArray = String.valueOf(count).toCharArray();
                for(char c:tmpCharArray) {
                    result[pos++] = c;
                count = 1;
                }
            }
        }
        result[pos++] = tmp;
        char[] tmpCharArray = String.valueOf(count).toCharArray();
        for(char c:tmpCharArray) {
            result[pos++] = c;
        }
        return String.valueOf(result);
        //return new String(result);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = inputReader.readLine();
        int compressedLength = computeLength(inputLine);

        if(compressedLength >= inputLine.length())
            System.out.println(inputLine);
        else
            System.out.println(compress(inputLine, compressedLength));
    }

}

//int -> char: char c = (char)(i + '0').
//charArray -> String: String.valueOf(charArray); or new String(charArray);
//get int digits: String.valueOf(int).length();
//int -> charArray: String.valueOf(int).toCharArray();

