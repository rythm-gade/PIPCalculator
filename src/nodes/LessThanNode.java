package nodes;

/*Rythm Gade
LessThanNode
 */

public class LessThanNode extends BooleanOperatorNode {

    public LessThanNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, "<");
    }

    @Override
    public int evaluate() {
        if(leftChild.evaluate() < rightChild.evaluate()){
            return 1;
        }

        else {
            return 0;
        }

    }
}

