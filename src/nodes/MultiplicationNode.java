package nodes;

/*Rythm Gade
MultiplicationNode
 */

public class MultiplicationNode  extends BinaryOperatorNode {

    public MultiplicationNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.MULT_DIVIDE, "*");

    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() * rightChild.evaluate();
    }

    @Override
    public String toString() {
        return leftChild.toString() + " * " + rightChild.toString();
    }
}
