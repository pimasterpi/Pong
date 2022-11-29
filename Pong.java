import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Pong implements Runnable {
    int upCount = 0;
    int downCount = 0;
    int leftCount = 0;
    int rightCount = 0;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Pong());
    }

    public Pong() {

    }

    public void run() {
        JFrame frame = new JFrame("Pong") {{
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setSize(600, 400);
        }};


        JLabel up = new JLabel() {{
            setText("Up: " + upCount);
        }};
        JLabel down = new JLabel() {{
            setText("Down: " + downCount);
        }};
        JLabel left = new JLabel() {{
            setText("Left: " + leftCount);
        }};
        JLabel right = new JLabel() {{
            setText("Right: " + rightCount);
        }};

        JPanel panel = new JPanel() {{
            add(up);
            add(down);
            add(left);
            add(right);
        }};

        frame.add(panel);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> up.setText("Up: " + (++upCount));
                    case KeyEvent.VK_DOWN -> down.setText("Down: " + (++downCount));
                    case KeyEvent.VK_LEFT -> left.setText("Left: " + (++leftCount));
                    case KeyEvent.VK_RIGHT -> right.setText("Right: " + (++rightCount));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}