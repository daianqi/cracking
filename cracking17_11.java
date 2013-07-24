/*
Implement a method rand7() given rand5(). That is, given a method that generates a random number between 0 and 4 (inclusive),
write a method that generates a random number between 0 and 6 (inclusive).
*/

public static class cracking17_11 {
    //五进制,every number appear with each chance
    //00 = 0, 01 = 1, 10 = 5, 44 = 24

    public static int rand7() {
        while(true) {
            int tmp = 5*rand5()+rand5(); //五进制
            if(tmp<21) {   //cut by number dividable by 7
                return tmp%7;
            }
        }
    }
}