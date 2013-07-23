/*
Design a method to find the frequency of occurrences of any given word in a book.
*/


import java.lang.String;
import java.util.Hashtable;

//ask Q: use once (just search the whole file) or use repeatedly (build hashtable)
//containsKey & get
public static class cracking17_9 {
    public static Hashtable<String,int> buildHashTable(String[] file) {
        Hashtable<String, int> record = new Hashtable<String, int>();
        for(String s : file) {
            s = s.toLowerCase(); //stupidly forget
            if(s.trim() != "") {  //This method returns a copy of the string, with leading and trailing whitespace omitted.
                if(!record.containsKey(s))
                    record.put(s,0);
                record.put(s,record.get(s)+1); //attention
            }
        }
        return record;
    }

    public static int getFrequence(Hashtable<String, int> table, String str) {
        if(table == null || str == null) return -1; //important
        str = str.toLowerCase();
        if(table.containsKey(str))
            return table.get(str);
        else
            return 0;
    }
}
