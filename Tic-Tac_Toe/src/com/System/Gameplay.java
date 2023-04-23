package com.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gameplay extends JPanel implements MouseListener {

    int[][] board = new int[3][3];

    int lineWidth = 5;
    int lineLength=270;
    int x = 55, y = 140;
    int offset = 95;
    int a = 0, b= 0;
    int selX=0, selY=0;
    int turn=0, count=0;
    int player1Win=0, player2Win=0;
    boolean gameOver=false;

    Gameplay(){
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;
            }
        }
    }

    @Override
    public void paint(Graphics g) {

        //bg
        g.setColor(Color.BLACK);
        g.fillRect(0,0,650,500);

        //lines
        g.setColor(Color.WHITE);
        g.fillRoundRect(x,y,lineLength,lineWidth,5,30);
        g.fillRoundRect(x,y+offset,lineLength,lineWidth,5,30);
        g.fillRoundRect(y,x,lineWidth,lineLength,30,5);
        g.fillRoundRect(y+offset,x,lineWidth,lineLength,30,5);

        //player_info
        Font font = new Font("",Font.BOLD,35);
        g.setFont(font);
        g.drawString("Player 1 (O)",400,100);
        font = new Font("",Font.BOLD,40);
        g.setFont(font);
        g.drawString(String.valueOf(player1Win),480,180);
        font = new Font("",Font.BOLD,35);
        g.setFont(font);
        g.drawString("Player 2 (X)",400,250);
        font = new Font("",Font.BOLD,40);
        g.setFont(font);
        g.drawString(String.valueOf(player2Win),480,330);

        if(turn==0){
            g.setFont(new Font("",Font.PLAIN,25));
            g.drawString("Its Player 1 (O) turn",200,400);
        }else {
            g.setFont(new Font("",Font.PLAIN,25));
            g.drawString("Its Player 2 (X) turn",200,400);
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){

                }else if(board[i][j]==1){
                    g.setFont(new Font("",Font.BOLD,40));
                    g.drawString("O",85+(95*i),110+(95*j));
                }else if(board[i][j]==2){
                    g.setFont(new Font("",Font.BOLD,40));
                    g.drawString("X",85+(95*i),110+(95*j));
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selX=-1;
        selY=-1;
        a = e.getX();
        b= e.getY();
        if(a>55 && a< 139){
            selX=0;
        }else if(a>145 && a<232){
            selX=1;
        }else if(a>240 && a<329){
            selX=2;
        }else {
            selX=-1;
        }

        if(b>56 && b<136){
            selY=0;
        }else if(b>147 && b<232){
            selY=1;
        }else if(b>244 && b<329){
            selY=2;
        }else {
            selY=-1;
        }
        if(selX!=-1 && selY!=-1){
            if(turn==0){
                if(board[selX][selY]==0) {
                    board[selX][selY] = 1;
                    turn = 1;
                    count++;
                }
            }else {
                if(board[selX][selY]==0) {
                    board[selX][selY] = 2;
                    turn = 0;
                    count++;
                }
            }
        }

        repaint();

        checkWinner();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void checkWinner() {

        int temp = 0;

        if(board[0][0]==board[0][1] && board[0][1] == board[0][2] && board[0][0] != 0){
            temp= board[0][0];
        }else if(board[1][0]==board[1][1] && board[1][1] == board[1][2] && board[1][0] != 0){
            temp=board[1][0];
        }else if(board[2][0]==board[2][1] && board[2][1] == board[2][2] && board[2][0] != 0){
            temp=board[2][0];
        }else if(board[0][0]==board[1][0] && board[1][0] == board[2][0] && board[0][0] != 0){
            temp=board[0][0];
        }else if(board[0][1]==board[1][1] && board[1][1] == board[2][1] && board[0][1] != 0){
            temp=board[0][1];
        }else if(board[0][2]==board[1][2] && board[1][2] == board[2][2] && board[0][2] != 0){
            temp=board[0][2];
        }else if(board[0][0]==board[1][1] && board[1][1] == board[2][2] && board[0][0]!=0){
            temp=board[0][0];
        }else if (board[0][2]==board[1][1] && board[1][1] == board[2][0] && board[0][2]!=0){
            temp=board[0][2];
        }else if(count==9){
            temp=3;
        }

        if(temp==1){
            JOptionPane.showMessageDialog(this,"Player 1(O) Thulo vayes");
            player1Win++;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j]=0;
                }
            }
            turn=0;
            gameOver=false;
            repaint();
        }else if(temp==2){
            JOptionPane.showMessageDialog(this,"Player 2(X) Thulo vayes");
            player2Win++;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j]=0;
                }
            }
            turn=0;
            gameOver=false;
            repaint();
        }else if(temp==3){
            JOptionPane.showMessageDialog(this,"Thukka muji");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    board[i][j]=0;
                }
            }
            turn=0;
            gameOver=false;
            repaint();
        }
    }
}
