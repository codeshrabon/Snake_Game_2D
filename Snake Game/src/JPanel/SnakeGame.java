package JPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextLayout;

public class SnakeGame extends JPanel implements ActionListener {
    private final int width;
    private final int height;
    private static final int FRAME_RATE = 20;
    private boolean gameStart = false;


    public SnakeGame( int width, final int height) {

        // it's an optional to use super()
        // using super is give privilege
        super();

        this.width = width;
        this.height = height;

        //setForeground(Color.GREEN);
        // without dimension, it will not show display
        // set prefer size with dimension new object class
        // using height and weight
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.BLACK);
    }
    public void startGame(){
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameStart = true;
                    System.out.println("Space was Pressed");
                    //super.keyPressed(e);
                }
            }
        });

        //adding timer
        new Timer(1000 / FRAME_RATE, this).start();

        // repaint() moved to ActionListener method
        // access JPanel component graphic
        // will call java swing api
        //repaint();
    }

    // call paint component of jPanel
    @Override
    protected void paintComponent(Graphics graphicKey) {
        super.paintComponent(graphicKey);
        if (!gameStart) {


            graphicKey.setColor(Color.yellow);
        /*graphicKey.draw3DRect(20,20,20,20, true);
        graphicKey.draw3DRect(40,40,20,20, true);
        graphicKey.draw3DRect(60,60,20,20, true);
        graphicKey.draw3DRect(80,80,20,20, true);*/
            //graphicKey.draw3DRect(0,0,20,20, true);
        /*graphicKey.draw3DRect(100,100,20,20, true);
        graphicKey.draw3DRect(200,200,20,20, true);
        graphicKey.draw3DRect(300,300,20,20, true);*/

            /*graphicKey.create().clipRect(10,40,40,40);*/
            /*graphicKey.clipRect(20,40,40,40);*/
            /*setBorder(new BorderUIResource(graphicKey.getFont();));*/

            /*graphicKey.drawString("Helo this is snake game", 10,10);*/
            graphicKey.setFont(graphicKey.getFont().deriveFont(20F));

            int currentHeight = height / 2;
        /*int currentWidth = width / 2;
        graphicKey.drawString("Welcome to the game \n PRESS Enter/Space",currentWidth,currentHeight);*/

            // Graphics2D class object give control over geometry position
            final var graphics2D = (Graphics2D) graphicKey;
            //FontRenderContext inject inside Graphics2D class, its Font context
            final var fontFRC = graphics2D.getFontRenderContext();

            //for multiline context we need this TextLayout class
            final var message = "!    Welcome   !\nPRESS enter/space";
            for (final var line : message.split("\n")) {

                //didn't work
           /* int currentWidth = width / 2;
        graphicKey.drawString("Welcome to the game \n PRESS Enter/Space",currentWidth,currentHeight);*/


                final var layout = new TextLayout(line, graphicKey.getFont(), fontFRC);

                //Returns the bounds of this TextLayout. The bounds are in standard coordinates
                final var bounds = layout.getBounds();
                final var targetWidth = (float) (width - bounds.getWidth()) / 2;
                layout.draw(graphics2D, targetWidth, currentHeight);
                currentHeight += graphicKey.getFontMetrics().getHeight();

            }




        }
        /*System.out.println("Message shows");*/
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        //moved from startGame method
        repaint();
    }

}
