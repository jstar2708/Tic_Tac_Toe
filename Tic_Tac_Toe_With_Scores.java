package com.company;

import java.util.Scanner;

public class Tic_Tac_Toe_With_Scores {
    static int count1 = 8;
    static int count2 = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This is a 10 match tic tac toe game");
        System.out.println();
        System.out.print("Player 1 enter your name : ");
        String player1 = input.next();
        System.out.print("Player 2 enter your name : ");
        String player2 = input.next();
        int match = 1;
        while(count1<10 && count2<10){
            char ch;
            System.out.println();
            System.out.print("Please press 'Y' for a new match and 'N' to exit : ");
            ch = input.next().trim().charAt(0);
            if(ch == 'Y'){
                Game(match,player1,player2);
            }
            else if(ch == 'N'){
                System.out.println("Thank you");
                break;
            }
            else{
                System.out.println("Invalid choice!!");
            }
            match++;
        }
        if(count1>10){
            System.out.println();
            System.out.println(player1 + " has won the series!!");
        }
        else if(count2>10){
            System.out.println();
            System.out.println(player2 + " has won the series!!");
        }
    }

    static void Game(int match,String player1,String player2){
        Scanner input = new Scanner(System.in);
        System.out.println("MATCH " + match);
        String[][] board = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}
        };
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println();
        System.out.println(player1 + " has been allotted X!");
        System.out.println(player2 + " has been allotted O!");
        int step = 1;
        while(step<10){
            if(step%2 == 1){
                PlayerInput(board,nums,player1,"X");
            }
            else{
                PlayerInput(board,nums,player2,"O");
            }
            if(Is_winner(board,"X")){
                Display(board);
                System.out.println(player1 + " has won the game!!");
                System.out.println();
                count1++;
                System.out.println("Score--->");
                System.out.println(player1 + " : " + count1);
                System.out.println(player2 + " : " + count2);
                return;
            }
            if(Is_winner(board,"O")){
                Display(board);
                System.out.println(player2 + " has won the game!!");
                System.out.println();
                count2++;
                System.out.println("Score--->");
                System.out.println(player1 + " : " + count1);
                System.out.println(player2 + " : " + count2);
                return;
            }
            step++;
        }
        System.out.println("No Winner!! ");
        System.out.println("Match has been drawn!");
        System.out.println();
        System.out.println("Score--->");
        System.out.println(player1 + " : " + count1);
        System.out.println(player2 + " : " + count2);
    }

    static void PlayerInput(String[][] board,int [][] nums,String p,String ch){
        Scanner input = new Scanner(System.in);
        Display(board);
        System.out.println(p + "'s turn -- >(" + ch + ")");
        System.out.print("Enter the position : ");
        int pos = input.nextInt();
        if(!(Pos_checker(pos))){
            PlayerInput(board,nums,p,ch);
        }
        else{
            IndexFinder(board,nums,p,pos,0,2,ch);
        }
    }

    static void IndexFinder(String[][] board,int[][] nums,String p,int x,int i,int j,String ch){
        while(i<3 && j>=0){
            if(nums[i][j]>x){
                j--;
            }
            else if(nums[i][j]<x){
                i++;
            }
            else{
                break;
            }
        }
        if(board[i][j].equals("X") || board[i][j].equals("O")){
            System.out.println("Entered position is already occupied!!");
            System.out.println("Please enter valid position!");
            PlayerInput(board,nums,p,ch);
        }
        else{
            board[i][j] = ch;
        }
    }

    static boolean Pos_checker(int x){
        if(x>9 || x<1){
            System.out.println("Entered position out of range!");
            System.out.println("Enter position again!");
            return false;
        }
        return true;
    }

    static void Display(String[][] board){
        System.out.println("TIC TAC TOE");
        System.out.println();
        System.out.println("---------------");
        System.out.println();
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.print("  " + board[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("---------------");
    }

    static boolean Is_winner(String[][] board,String n){
        if (board[0][0].equals(n) && board[0][1].equals(n) && board[0][2].equals(n))
        {
            return true;
        }
        else if (board[0][0].equals(n) && board[1][0].equals(n) && board[2][0].equals(n))
        {
            return true;
        }
        else if (board[2][0].equals(n) && board[2][1].equals(n) && board[2][2].equals(n))
        {
            return true;
        }
        else if (board[2][2].equals(n) && board[1][2].equals(n) && board[0][2].equals(n))
        {
            return true;
        }
        else if (board[0][0].equals(n) && board[1][1].equals(n) && board[2][2].equals(n))
        {
            return true;
        }
        else if (board[2][0].equals(n) && board[1][1].equals(n) && board[0][2].equals(n))
        {
            return true;
        }
        else if (board[1][0].equals(n) && board[1][1].equals(n) && board[1][2].equals(n))
        {
            return true;
        }
        else if (board[0][1].equals(n) && board[1][1].equals(n) && board[2][1].equals(n))
        {
            return true;
        }
        return false;
    }
}
