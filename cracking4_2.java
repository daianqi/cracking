/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.LinkedList;

public class cracking4_2 {

    public static boolean hasRouteDepth(int start, int end, boolean[][] map, boolean[] visited) {
        if(start == end)
            return true;
        System.out.println(start);
        visited[start] = true;
        for(int i = 0; i< map[0].length; i++) {
            if(visited[i] == false && map[start][i] == true)
                return hasRouteDepth(i, end, map, visited);
        }
        return false;
    }

    public static boolean hasRouteBreadth(int start, int end, boolean[][] map, boolean[] visited) {
        LinkedList<Integer> toVisit = new LinkedList<Integer>();
        toVisit.add(start);
        while(!toVisit.isEmpty()) {
            int tmp = toVisit.removeFirst();
            System.out.println(tmp);
            visited[tmp] = true;
            for(int i = 0;i<map[0].length;i++) {
                if(visited[i] == false && map[tmp][i] == true) {
                    if(i == end) {
                        return true;
                    }
                    else {
                        toVisit.add(i);
                    }
                }
            }

        }
        return false;
    }


    public static void main(String[] args) {
        boolean[] visited = new boolean[5];
        boolean[][] map = new boolean[5][5];
        map[0][2] = true;
        map[2][1] = true;
        map[0][3] = true;
        map[3][1] = true;
        map[1][4] = true;
        System.out.println(hasRouteBreadth(0,4,map,visited)?"Yes":"No");
//        System.out.println(hasRouteDepth(0,4,map,visited)?"Yes":"No");

    }
}