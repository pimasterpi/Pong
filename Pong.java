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
        JFrame frame = new JFrame("Pong");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        JLabel up = new JLabel();
        JLabel down = new JLabel();
        JLabel left = new JLabel();
        JLabel right = new JLabel();

        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);

        up.setText("Up: " + upCount);
        down.setText("Down: " + downCount);
        left.setText("Left: " + leftCount);
        right.setText("Right: " + rightCount);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    up.setText("Up: " + (++upCount));
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    down.setText("Down: " + (++downCount));
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left.setText("Left: " + (++leftCount));
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right.setText("Right: " + (++rightCount));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        frame.add(panel);

    }
}
