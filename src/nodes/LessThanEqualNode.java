package nodes;

/*Rythm Gade
LessThanEqualNode
 */

public class LessThanEqualNode  extends BooleanOperatorNode {

    public LessThanEqualNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, "<=");
    }

    @Override
    public int evaluate() {
        if(leftChild.evaluate() <= rightChild.evaluate()){
            return 1;
        }

        else {
            return 0;
        }

    }
}
