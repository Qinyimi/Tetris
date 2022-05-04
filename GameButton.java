import javax.swing.*;
import java.awt.event.ActionListener;

public class GameButton extends JButton {
    public GameButton(ActionListener actionListener, String text, String actionCommand, int x, int y, int width, int height) {
        super(text);
        super.addActionListener(actionListener);
        super.setActionCommand(actionCommand);
        super.setBounds(x, y, width, height);
    }
}
