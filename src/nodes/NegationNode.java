package nodes;

/*Rythm Gade
NegationNode
 */

public class NegationNode  extends UnaryOperatorNode {

    public NegationNode(PIPCalcNode child){
        super(child,"_", Precedence.MULT_DIVIDE);
    }

    @Override
    public int evaluate() {
        return 0 - child.evaluate();
    }
}
