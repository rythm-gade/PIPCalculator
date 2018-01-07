package nodes;

/*Rythm Gade
Division Node
 */

public class DivisionNode extends BinaryOperatorNode {

    public DivisionNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.MULT_DIVIDE, "//");

    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() / rightChild.evaluate();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
