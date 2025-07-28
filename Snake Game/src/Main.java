import javax.swing.*;
import JPanel.SnakeGame;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int  WIDTH = 800;
    private static final int HEIGHT = 600;


    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        final JFrame jframe = new JFrame("Snake Game");

        // set frame size
        jframe.setSize(WIDTH, HEIGHT);

        // make the panel into the frame by passing the frame size
        // Here JPanel is causing of playing game
        SnakeGame snakeGame = new SnakeGame(WIDTH, HEIGHT);

        // initialize inside jframe this object
        jframe.add(snakeGame);

        //set frame location indicate
        jframe.setLocationRelativeTo(null);

        //set closing
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set frame resizing
        jframe.setResizable(true);


        // set frame visualization
        jframe.setVisible(true);



        // pack the panel into the frame
        jframe.pack();

        // object call to start game
        snakeGame.startGame();
    }
}