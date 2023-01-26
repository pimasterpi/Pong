import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pong extends JComponent implements Runnable {
    Image image;
    Graphics2D graphics2D;
    int verticalPositionBar = 0;
    int horizontalPositionBall = 0;
    int verticalPositionBall = 0;

    double horizontalVelocityBall = 5;
    double verticalVelocityBall = 5;
    Pong draw;

    Timer timer;

    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer) {

                draw.verticalPositionBall += draw.verticalVelocityBall;
                draw.horizontalPositionBall += draw.horizontalVelocityBall;

                if (draw.verticalPositionBall <= 0 && draw.verticalVelocityBall < 0 || draw.verticalPositionBall >= 355 && draw.verticalVelocityBall > 0) {
                    draw.verticalVelocityBall *= -1;
                }

                if (draw.horizontalPositionBall <= 0 && draw.horizontalVelocityBall < 0 || draw.horizontalPositionBall >= 580 && draw.horizontalVelocityBall > 0) {
                    draw.horizontalVelocityBall *= -1;
                }
                if (draw.horizontalPositionBall <= 15 && draw.horizontalVelocityBall < 0 && (draw.verticalPositionBar - draw.verticalPositionBall <= 10 && draw.verticalPositionBall - draw.verticalPositionBar - 100 <= 0)) {
                    draw.horizontalVelocityBall *= -1;
                }



                draw.refresh();
                timer.restart();
            }
        }
    };


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

        timer = new Timer(10, taskPerformer);
        timer.setRepeats(true);
        timer.start();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP, KeyEvent.VK_LEFT -> {
                        if (draw.verticalPositionBar > 0) draw.verticalPositionBar -= 5;
                        draw.refresh();
                    }
                    case KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT -> {
                        if (draw.verticalPositionBar < 265) draw.verticalPositionBar += 5;
                        draw.refresh();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }


    public void refresh() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        graphics2D.fillRect(0, verticalPositionBar, 15, 100);
        graphics2D.fillOval(horizontalPositionBall, verticalPositionBall, 10, 10);

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