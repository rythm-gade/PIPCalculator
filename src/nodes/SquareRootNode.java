package nodes;

/*Rythm Gade
SquareRootNode
 */

public class SquareRootNode extends UnaryOperatorNode {

    public SquareRootNode(PIPCalcNode child){
        super(child,"@", Precedence.POWER);
    }

    @Override
    public int evaluate() {
        return (int)Math.sqrt((double)child.evaluate());
    }
}
