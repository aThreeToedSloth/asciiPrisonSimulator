package Managers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Renderer{
    private JLabel grid;
    private JLabel textBox;
    StringBuilder oldText = new StringBuilder();
    private KeyListener listener;

    public Renderer(KeyListener listener){
        this.listener = listener;
    }

    public void render(){
        createFrame();
    }

    private void createFrame(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        grid = new JLabel();
        grid.setHorizontalAlignment(JLabel.CENTER);
        grid.setVerticalAlignment(JLabel.CENTER);
        grid.setFont(new Font("Monospaced", Font.PLAIN, 15));
        panel.setBounds(0,30,400,250);
        panel.setLayout(new BorderLayout());
        panel.add(grid);

        textBox = new JLabel();
        textBox.setHorizontalAlignment(JLabel.CENTER);
        textBox.setVerticalAlignment(JLabel.CENTER);
        textBox.setFont(new Font("Monospaced", Font.PLAIN, 10));
        panel1.setBounds(0,250,400,150);
        panel1.setLayout(new BorderLayout());
        panel1.add(textBox);

        frame.add(panel);
        frame.add(panel1);

        grid.setFocusable(true);
        grid.addKeyListener(listener);

        grid.setText("");
        textBox.setText("<html>You are in prison - use WASD to move around.</html>");
    }

    public void updateGrid(String text){

        oldText.append(text);
        grid.setText(String.format("<html>%s</html>",oldText));
    }

    public void clearGrid(){
        oldText.setLength(0);
    }

    public void displayText(String text){
        textBox.setText(text);
    }
}
