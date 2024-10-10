package Managers;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Renderer{
    private JFrame frame;
    private JLabel grid;
    private JLabel textBox;
    private JPanel panel;
    StringBuilder oldText = new StringBuilder();
    private KeyListener listener;

    public Renderer(KeyListener listener){
        this.listener = listener;
    }

    public void render(){
        createFrame();
    }

    private void createFrame(){
        frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);

        panel = new JPanel();

        grid = new JLabel();
        panel.add(grid);

        textBox = new JLabel();
        panel.add(textBox);

        frame.add(panel);

        grid.setFocusable(true);
        grid.addKeyListener(listener);

        grid.setText("");
    }

    public void updateGrid(String text){

        oldText.append(text);
        grid.setText(String.format("<html><pre>%s</pre></html>",oldText));
    }

    public void clearGrid(){
        oldText.setLength(0);
    }

    public void displayText(String text){
        textBox.setText(text);
    }
}
