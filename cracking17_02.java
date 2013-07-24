/*
Design an algorithm to figure out if someone has won a game of tic-tac-toe.
*/

import java.lang.System;

public class cracking17_2 {
    public static int hasWonN*N (int[][] board) {
        //test row
        for(int row = 0;row < board.length;row++) {
            if(board[row][0]!= 0){
                for(int col = 1;col<board[0].length;col++) {  //start from 1!
                    if(board[row][col]!=board[row][col+1])
                        break;
                }
                if(col==board[0].length)
                    return board[row][0];
            }
        }
        //test column
        for(int col = 0;col < board[0].length;col++) {
            if(board[0][col]!= 0){
                for(int row = 1;row < board.length;row++) {
                    if(board[row][col]!= board[row-1][])
                    break;
                }
                if(row == board.length)
                    return board[col][0];
            }
        }
        //test diagonal
        if(board[board.length-1][0]!= 0){
            for(row = 1;row<board.length;row++) {
                if(board[row][row] != board[row-1][row-1])
                    break;
            }
            if(row==board.length)
                return board[row][row];
        }
        //test reverse diagonal
        if(board[board.length-1][0] != 0){
            for(row = 1;row<board.length;row++) {
                if(board[board.length - row - 1][row] != board[board.length - row][row-1])  //attention!!!
                    break;
            }
            if(row == board.length)
                return [row-1][0];
        }
        return 0;
    }

    public static int convertBoardToInt(int[][] board) {
        int sum = 0;
        int factor = 1;
        for(int row = 0;row<board.length;row++) {
            for(int col = 0;col<board[0].length;col++) {
                sum += factor*board[row][col];
                factor *= 3;
            }
        }
        return sum; //3^0*[0][0] + 3^1*[0][1] + ... + 3^8*[2][2]
    }

    public static int hasWon(int[][] board) {
        for(int i = 0;i<board.length;i++) {    //judge for empty is important
            if(board[i][0]!=0 && board[i][0]==board[i][1]&&board[i][0]==board[i][2])
                return board[i][0];
            if(board[0][i]!=0 && board[0][i]==board[1][i]&&board[0][i]==board[2][i])
                return board[0][i];
        }
        if(board[0][0]!=0 && board[0][0]==board[1][1]&&board[0][0]==board[2][2])
            return board[0][0];
        if(board[2][0]!=0 && board[2][0]==board[1][1]&&board[2][0]==board[0][2])
            return board[2][0];
        return 0;
    }

    public static void main(String[] args) {
        int [][] board1 = {{1,2,0},{0,1,2},{2,0,1}};
        int [][] board2 = {{2,1,0},{2,0,1},{2,1,0}};
        int [][] board3 = {{2,1,2},{0,2,1},{0,1,0}};

        switch (hasWon(board1)) {
            case 1:
                System.out.println("Board1: Player1 won");
                break;
            case 2:
                System.out.println("Board1: Player2 won");
                break;
            default:
                System.out.println("Board1: No one won");
        }

        switch (hasWon(board2)) {
            case 1:
                System.out.println("Board2: Player1 won");
                break;
            case 2:
                System.out.println("Board2: Player2 won");
                break;
            default:
                System.out.println("Board2: No one won");
        }

        switch (hasWon(board3)) {
            case 1:
                System.out.println("Board3: Player1 won");
                break;
            case 2:
                System.out.println("Board3: Player2 won");
                break;
            default:
                System.out.println("Board3: No one won");
        }
    }
}
