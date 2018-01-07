package nodes;

/*Rythm Gade
EqualityNode
 */

public class EqualityNode extends BooleanOperatorNode {

    public EqualityNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, "==");
    }

    @Override
    public int evaluate() {
        if(leftChild.evaluate() == rightChild.evaluate()){
            return 1;
        }

        else {
            return 0;
        }

    }
}

