package be.kdg.java.model;

public class Block {
    private final BlockShape shape;
    public Block(BlockShape Shape){
            this.shape = Shape;
    }
    public BlockShape getShape() {
        return shape;
    }
}
