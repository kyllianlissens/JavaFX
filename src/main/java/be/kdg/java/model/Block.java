package be.kdg.java.model;

/**
 *  De klasse die de shape bijhoud
 *
 *
 * @author Kyllian Lissens
 * @version 1.0
 */

public class Block {
    private final BlockShape shape;

    public Block(BlockShape Shape) {
        this.shape = Shape;
    }

    public BlockShape getShape() {
        return shape;
    }
}
