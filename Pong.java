import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pong extends JComponent implements Runnable {
    Image image;
    Graphics2D graphics2D;
    int verticalPosition = 0;

    Pong draw;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Pong());
    }

    public Pong() {
    }

    public void run() {

        JFrame frame = new JFrame("Pong") {{
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setSize(600, 400);
            setLocationRelativeTo(null);
            setVisible(true);
        }};

        Container content = frame.getContentPane();
        content.setSize(600, 400);
        content.setLayout(new BorderLayout());
        draw = new Pong();
        content.add(draw, BorderLayout.CENTER);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP, KeyEvent.VK_LEFT -> {
                        if (verticalPosition > 0) verticalPosition -= 5;
                        draw.paddleMove(verticalPosition);
                        System.out.println(verticalPosition);
                    }
                    case KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT -> {
                        if (verticalPosition < 265) verticalPosition += 5;
                        draw.paddleMove(verticalPosition);
                        System.out.println(verticalPosition);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public void paddleMove(int verticalPosition) {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        graphics2D.fillRect(0, verticalPosition, 15, 100);

        repaint();
    }


    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }
}