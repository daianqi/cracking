/*
Explain the data structures and algorithms that you would use to design an in-memory file system. Illustrate with an example
in code where possible.
*/

import java.lang.System;
import java.util.ArrayList;

public class cracking8_9 {
    public abstract class Entry {
        protected Directory parent;
        protected long created;
        protected long lastUpdated;
        protected long lastAccessed;
        protected String name;

        public Entry (String n, Directory p) {
            name = n;
            parent = p;
            created = System.currentTimeMillis();
            lastUpdated = System.currentTimeMillis();
            lastAccessed = System.currentTimeMillis();
        }

        public boolean delete() {
            if(parent == null) return false;
            return parent.deleteEntry(this);
        }

        public abstract int size();

        public String getFullPath() {
            if(parent == null) return name;
            else {
                return parent.getFullPath() + "/" + name;
            }
        }

        //getters and setters
        public long getCreationTime() {return created;}
        public long getLastUpdatedTime() {return lastUpdated;}
        public long getLastAccessedTime() {return lastAccessed;}
        public void changeName(String n) {name = n;}
        public String getName() {return name;}
    }

    public class File extends Entry {
        private String content;
        private int size;
        public File(String n, Directory p, int sz) {
            super(n,p);
            size = sz;
        }
        public int size() {return size;}
        public String getContent() {return content;}
        public void setContent(String c) {content = c;}
    }

    public class Directory extends Entry {
        protected ArrayList<Entry> contents;

        public Directory(String n, Directory p) {
            super(n,p);
            contents = new ArrayList<Entry>();
        }
        public int size() {
            int size = 0;
            for(Entry e : contents) {
                size += e.size();
            }
            return size;
        }

        public int numberOfFiles() {
            int count = 0;
            for(Entry e : contents) {
                if(e instanceof Directory) {
                    count++;
                    count += ((Directory) e).numberOfFiles();
                } else if(e instanceof File) {
                    count ++;
                }
            }
            return count;
        }

        public boolean deleteEntry(Entry e) {
            return contents.remove(e);
        }

        public void addEntry (Entry e) {
            contents.add(e);
        }

        protected ArrayList<Entry> getContents() {return contents;}
    }
}