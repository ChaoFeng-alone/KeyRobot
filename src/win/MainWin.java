package win;

import main.Main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWin {
    public MainWin() {
        Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"点击确定，5秒钟后开始打字","提示",JOptionPane.PLAIN_MESSAGE);
                try {
                    Main.start();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }



    private JPanel MainPanel;
    private JTextArea input;
    private JTextArea output;
    private JLabel lable1;
    private JLabel lable2;
    private JToolBar toolBar;
    private JButton Button;

    public String getInput() {
        return input.getText();
    }

    public void outputAppend(char c) {
        output.append(String.valueOf(c));
    }
}
