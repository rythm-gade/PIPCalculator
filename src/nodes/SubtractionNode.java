package nodes;

/*Rythm Gade
SubtractionNode
 */

public class SubtractionNode extends BinaryOperatorNode {

    public SubtractionNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.ADD_SUBTRACT, "-");

    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() - rightChild.evaluate();
    }

    @Override
    public String toString() {
        return leftChild.toString() + " - " + rightChild.toString();
    }
}
