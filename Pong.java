import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pong extends JComponent implements Runnable {
    int verticalPosition = 0;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Pong());
    }

    public Pong() {
            addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP, KeyEvent.VK_LEFT -> {
                        //yPosition.setText("yPosition: " + (++verticalPosition));
                    }
                    case KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT -> {
                        //yPosition.setText("yPosition: " + (--verticalPosition));
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void run() {
        JFrame frame = new JFrame("Pong") {{
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setSize(600, 400);
            setLocationRelativeTo(null);
            setVisible(true);
        }};


        JLabel yPosition = new JLabel() {{
            setText("yPosition: " + verticalPosition);
        }};

        JPanel panel = new JPanel() {{
            add(yPosition);
        }};

        frame.add(panel);

    }


    private Image image;
    private Graphics2D graphics2D;

    /**
     * Initializes painting features for JFrame
     *
     * @param g Graphics object to set up the painting features
     */
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }
}