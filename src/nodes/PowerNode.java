package nodes;
import java.math.*;

/*Rythm Gade
PowerNode
 */

public class PowerNode extends BinaryOperatorNode {

    public PowerNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.POWER, "^");

    }

    @Override
    public int evaluate() {
        return (int)Math.pow((double)leftChild.evaluate(), (double) rightChild.evaluate());
    }

    @Override
    public String toString() {
        return leftChild.toString() + " ^ " + rightChild.toString();
    }
}
