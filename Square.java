public class Square extends Shape {

    public Square(int X, int Y) {
        super();
        this.locations.set(0, new Tuple(X + Block.getHalfLength(), Y + Block.getHalfLength()));
        this.locations.add(new Tuple(X + Block.getHalfLength(), Y + Block.getHalfLength() * 3));
        this.locations.add(new Tuple(X + Block.getHalfLength() * 3, Y + Block.getHalfLength()));
        this.locations.add(new Tuple(X + Block.getHalfLength() * 3, Y + Block.getHalfLength() * 3));
        for (int i = 0; i < 3; i++) {
            this.blocks.add(new Block(MainFrame.getShapePen()));
        }
    }
    //TODO
}
