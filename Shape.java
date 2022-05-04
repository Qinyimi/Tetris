import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Shape extends JPanel {
    protected ArrayList<Block> blocks = new ArrayList<>();
    protected ArrayList<Tuple> locations = new ArrayList<>();
    Color color = MainFrame.getShapePen();

    public Shape() {
        try {
            blocks.add(new Block());
            locations.add(new Tuple(0, 0));
//            throw new Exception("Warning: default block generated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Shape(ArrayList<Block> blocks, ArrayList<Tuple> locations) {
        this.blocks = blocks;
        this.locations = locations;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public ArrayList<Tuple> getShapeLocation() {
        return locations;
    }

}
