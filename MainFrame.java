import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private static MainFrame mainFrame;
    private static ArrayList<JPanel> panels = new ArrayList<>();
    //    static Color pen = new Color(255,0,0);
    private static Color panelPen = Color.GRAY;
    private static Color shapePen = Color.RED;
    private static final Tuple blockSize = new Tuple(40, 40);
    private static final Tuple frameSize = new Tuple(800, 800);
//    static Toolkit kt = Toolkit.getDefaultToolkit();
//    Dimension screenSize = kt.getScreenSize();


    public static void main(String[] args) {


        mainFrame = new MainFrame();
        mainFrame.initiateFrame("test title", frameSize);
        //TODO:
//        Square square = new Square(new Tuple(1,1));

        //不可见
//        JPanel nothingButPanel = initiatePanel();
//        frame.add(nothingButPanel);

        JPanel panel = initiatePanel(new Tuple(400, 400), panelPen);
        panel.add(new JLabel("This is panel1"));
        JPanel panel2 = initiatePanel(new Tuple(400, 400), panelPen);
        panel2.add(new JLabel("This is panel2"));
        GamePanel gamePanel = new GamePanel();
        mainFrame.addPanel(panel);

        JButton button = new JButton("test button");
        JButton button2 = new JButton("test button2");
        JButton button3 = new JButton("new game");
//        button.addActionListener(e -> {
//            //TODO
//        });
        button.addActionListener(event -> mainFrame.setPanel((JPanel) button.getParent(), panel2));
        button2.addActionListener(event -> mainFrame.setPanel((JPanel) button2.getParent(), panel));
        button3.addActionListener(event -> mainFrame.setPanel((JPanel) button3.getParent(), gamePanel));

        panel.add(button);
        panel2.add(button2);
        panel2.add(button3);

        //流式布局
        panel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        //网格布局
//        panel.setLayout(new GridLayout(1,2,5,5));
//        panel.setLayout(new GridLayout(2,1,5,5));
        //TODO: more layout...
    }

    /**
     * 关于如何合作
     * This method performs...
     *
     * @param title set title of the frame...
     * @param size  set size of the frame...
     * @author yourName
     */
    private void initiateFrame(String title, Tuple size) {
        new JFrame(title);
        //窗口标题
//        frame.setTitle(title);
        //窗口尺寸
        setSize(size.x, size.y);
        //绑定关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //可见
        setVisible(true);
        //add your code here:
        //TODO: add something...
    }

    /**
     * @param color set pen with color
     */
    private static void setPanelPen(Color color) {
        panelPen = color;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    private static void setShapePen(Color color) {
        shapePen = color;
    }

    static Color getPanelPen() {
        return panelPen;
    }

    static Color getShapePen() {
        return shapePen;
    }

    private static JPanel initiatePanel() {
        //TODO: more about initiate
        return new JPanel();
    }

    private void setPanel(JPanel panel1, JPanel panel2) {
        panel1.setVisible(false);
        add(panel2);
        panel2.setVisible(true);
        revalidate();
        repaint();
    }


    private static JPanel initiatePanel(Tuple size, Color color) {
        JPanel panel = new JPanel();
        panel.setSize(size.x, size.y);
        panel.setBackground(color);
        //TODO: panel.setMore...
        return panel;
    }

    private void addPanel(JPanel panel) {
        panels.add(panel);
        add(panel);
        setBounds(panel.getBounds());
    }


    public static Tuple getBlockSize() {
        return blockSize;
    }

    public static Tuple getFrameSize() {
        return frameSize;
    }
}

