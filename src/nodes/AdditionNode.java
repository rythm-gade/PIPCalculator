package nodes;

/*Rythm Gade
AdditionNode
 */

public class AdditionNode extends BinaryOperatorNode {

    public AdditionNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.ADD_SUBTRACT, "+");

    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() + rightChild.evaluate();
    }

    @Override
    public String toString() {
        return leftChild.toString() + " + " + rightChild.toString();
    }


}
