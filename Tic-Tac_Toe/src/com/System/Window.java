package com.System;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    Gameplay gameplay;
    JPanel pnl;
    Window(){
        gameplay=new Gameplay();
        setSize(650,500);
        setTitle("Tic-Tac-Toe");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gameplay);

    }
}
