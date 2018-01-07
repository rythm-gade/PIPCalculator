package nodes;

/*Rythm Gade
NotEqualNode
 */

public class NotEqualNode extends BooleanOperatorNode {

    public NotEqualNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, "!=");
    }

    @Override
    public int evaluate() {
        if(leftChild.evaluate() != rightChild.evaluate()){
            return 1;
        }

        else {
            return 0;
        }

    }
}
