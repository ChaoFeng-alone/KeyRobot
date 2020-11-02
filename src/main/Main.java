package main;

import win.MainWin;
import writer.Writer;

import javax.swing.*;

public class Main {
    static MainWin win;
    public static void main(String[] args){
        JFrame frame = new JFrame("嘲风手打模拟器");
        win = new MainWin();
        frame.setLocation(500,200);
        frame.setContentPane(win.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,500);
        frame.setVisible(true);
    }
    public static void start() throws InterruptedException {
        Writer writer = new Writer();

        Thread.sleep(5000);
        String tmp = win.getInput();
        String input[]=tmp.split("\n");

        for (int i = 0; i < input.length; i++) {
            Writer.writeString(win,input[i]);
            Writer.writeEnter();
        }
    }
}
