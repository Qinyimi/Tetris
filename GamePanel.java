import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.JPanel;

class GamePanel extends JPanel implements ActionListener {
    GameButton pause, start;
    private int step = 20;
    private int time = 500;
    private Timer timer;
    //    Random r = new Random(System.currentTimeMillis());
    private ArrayList<Shape> shapes = new ArrayList<>();

    public GamePanel() {
        pause = new GameButton(this, "暂停", "pause", 0, 0, 80, 40);
        this.add(pause);

        start = new GameButton(this, "开始游戏", "start", 100, 0, 80, 40);
        this.add(start);
        this.setLayout(null);
        this.setEnabled(false);

        addKeyListener(new Adapter());
    }

    private void removeAllShape() {
        shapes.clear();
    }

    private void rotate(Shape shape) {
        //TODO: rotate the shape
    }

    public void setTimer(int time) {
        this.time = time;
    }

    private Shape generated() {
        Shape newShape = new Square(MainFrame.getFrameSize().x / 4, 0);
        shapes.add(newShape);
        return newShape;
        //TODO: random generate Shape
    }

    private void flush() {
        //TODO: your flush algorithm,
        for (Shape shape : shapes) {
            for (Tuple location : shape.locations) {
                location.y += 10;
            }
        }
        repaint();
    }

    /**
     * Handle the keyboard event.
     */
    static class Adapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
//                case KeyEvent.VK_LEFT -> methodHere
//                case KeyEvent.VK_RIGHT -> methodHere
//                case KeyEvent.OTHER -> methodHere
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(MainFrame.getShapePen());
        try {
            for (Shape shape : shapes) {
                ArrayList<Block> blocks = shape.blocks;
                ArrayList<Tuple> locations = shape.locations;
                if (blocks.size() == locations.size()) {
                    for (int j = 0; j < blocks.size(); j++) {
                        int len = blocks.get(j).getUnitSize().x;
                        int wid = blocks.get(j).getUnitSize().y;
                        Tuple location = locations.get(j);
                        g.fillRect(location.x, location.y, len, wid);
                    }
                } else throw new Exception("Length of location is not same as blocks!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void hitCheck() {
        //TODO: check if hit any bound of box or other shape
        //If the previous one hits the bound of box, the next one should be generated.
//        generated();
    }

    private void startGame() {
        //TODO:
    }

    private class Cycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            flush();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(pause.getActionCommand())) {
            System.err.println("按下暂停按钮");
            //TODO
        } else if (e.getActionCommand().equals(start.getActionCommand())) {
            System.err.println("按下开始按钮");
            //TODO
            generated();
            timer = new javax.swing.Timer(time, new Cycle());
            timer.start();
        }
    }
}
