package com.company;

import java.util.Scanner;

public class Tic_Tac_Toe {
    static String[][] board = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };
    static int[][] nums = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Player 1 enter your name : ");
        String player1 = input.next();
        System.out.print("Player 2 enter your name : ");
        String player2 = input.next();
        System.out.println();
        System.out.println(player1 + " has been allotted X!");
        System.out.println(player2 + " has been allotted O!");
        int step = 1;
        while(step<10){
            if(step%2 == 1){
                PlayerInput(player1,"X");
            }
            else{
                PlayerInput(player2,"O");
            }
            if(Is_winner("X")){
                Display();
                System.out.println(player1 + " has won the game!!");
                return;
            }
            if(Is_winner("O")){
                Display();
                System.out.println(player2 + " has won the game!!");
                return;
            }
            step++;
        }
        System.out.println("No Winner!! ");
        System.out.println("Match has been drawn!");
    }

    static void PlayerInput(String p,String ch){
        Scanner input = new Scanner(System.in);
        Display();
        System.out.println(p + "'s turn -- >(" + ch + ")");
        System.out.print("Enter the position : ");
        int pos = input.nextInt();
        if(!(Pos_checker(pos))){
            PlayerInput(p,ch);
        }
        else{
            IndexFinder(p,pos,0,2,ch);
        }
    }

    static void IndexFinder(String p,int x,int i,int j,String ch){
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
            PlayerInput(p,ch);
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

    static void Display(){
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

    static boolean Is_winner(String n){
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
