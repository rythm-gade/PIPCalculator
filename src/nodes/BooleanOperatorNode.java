package nodes;

/*Rythm Gade
BooleanOperatorNode
 */

public abstract class BooleanOperatorNode extends BinaryOperatorNode {

    public BooleanOperatorNode(PIPCalcNode left, PIPCalcNode right, String operator){
        super(left, right, Precedence.BOOLEAN, operator);
    }

    @Override
    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }


}
