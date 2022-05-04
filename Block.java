import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

class Block {
    private static Tuple unitSize = MainFrame.getBlockSize();
    private static Color color = MainFrame.getShapePen();

    public Block(Tuple unitSize, Color color) {
        Block.unitSize = unitSize;
        Block.color = color;
    }

    public Block(Color color) {
        Block.color = color;
    }

    public Block(Tuple unitSize) {
        Block.unitSize = unitSize;
    }

    public Block(int length) {
        Block.unitSize = new Tuple(length, length);
    }

    public Block(int width, int height) {
        Block.unitSize = new Tuple(width, height);
    }

    public Block() {
        //TODO: default value
    }


    /**
     * 此处默认block为正方形
     *
     * @return Return half the length of each side of the square.
     */
    public static int getHalfLength() {
        try {
            if (unitSize.x == unitSize.y)
                return unitSize.x / 2;
            else throw new Exception("Not a square! width: " + unitSize.x + " height: " + unitSize.y);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Tuple getUnitSize() {
        return unitSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Block.color = color;
    }
}