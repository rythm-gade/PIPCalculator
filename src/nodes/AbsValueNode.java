package nodes;

/*Rythm Gade
AbsValueNode
 */

public class AbsValueNode extends UnaryOperatorNode {

    public AbsValueNode(PIPCalcNode child){
        super(child,"|", Precedence.MULT_DIVIDE);
    }

    @Override
    public int evaluate() {
        return Math.abs(child.evaluate());
    }
}
