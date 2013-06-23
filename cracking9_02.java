/*
Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?
FOLLOW UP
Imagine certain spots are "off limits", such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
*/

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;

public class cracking9_02 {

    public static int possiblePath(int x, int y, int X, int Y) {
        if(x == X-1 && y == Y-1)
            return 1;
        else if(x<X-1 && y<Y-1) {
            return possiblePath(x+1,y,X,Y) + possiblePath(x,y+1,X,Y);
        } else if(x<X-1)
            return possiblePath(x+1,y,X,Y);
        else
            return possiblePath(x,y+1,X,Y);
    }

    //follow up
    public static boolean hasPath(int x, int y, ArrayList<Point> path) {
        Point p = new Point(x,y);
        if(x==0 && y==0)
            return true;
        boolean success = false;
        if(x>=1 && isFree(x-1,y))
            success = hasPath(x-1,y,path);
        if(!success && y>=1 && isFree(x,y-1))
            success = hasPath(x,y-1,path);
        if(success)
            path.add(p);
        return success;
    }

    //follow up dynamic
    public static boolean hasPath(int x, int y, ArrayList<Point> path, Hashtable<Point,Boolean> cache) {
        Point p = new Point(x, y);
        if(cache.containsKey(p)) {
            return cache.get(p);
        }
        if(x==0&&y==0)
            return true;
        boolean success = false;
        if(x>=1 && isFree(x-1,y)) {
            success = hasPath(x-1,y,path,cache);
        }
        if(!success && y>=1&& isFree(x,y-1)) {
            success = hasPath(x,y-1,path,cache);
        }
        if(success) {
            path.add(p);
        }
        cache.put(p,success);
        return success;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(readBuffer.readLine());
        int Y = Integer.parseInt(readBuffer.readLine());

        System.out.println("# of possible paths : " + possiblePath(0, 0, X, Y));
    }
}