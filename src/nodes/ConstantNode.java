package nodes;

/*Rythm Gade
ConstantNode
 */

public class ConstantNode implements PIPCalcNode {

    int value;
    Precedence precedence;

    public ConstantNode(int value){
        this.value = value;
        this.precedence = Precedence.CONSTANT;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toPrefixString() {
        return Integer.toString(value);
    }

    @Override
    public String toInfixString() {
        return Integer.toString(value);
    }

    @Override
    public String toPostfixString() {
        return Integer.toString(value);
    }

    @Override
    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }

    @Override
    public boolean isOperation() {
        return false;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.Constant;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}


