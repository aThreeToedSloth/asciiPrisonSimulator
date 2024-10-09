package Managers;

import javax.swing.*;

public class Renderer {
    private JFrame frame;
    private JLabel grid;
    private JPanel panel;
    StringBuilder oldText = new StringBuilder();

    public void render(){
        createFrame();
    }

    private void createFrame(){
        frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);

        grid = new JLabel();
        panel = new JPanel();
        panel.add(grid);
        frame.add(panel);

        grid.setText("");
    }

    public void updateGrid(String text){

        oldText.append(text);
        grid.setText(String.format("<html><pre>%s</pre></html>",oldText));
    }

    public void clearGrid(){
        oldText.setLength(0);
    }
}
