package nodes;

/*Rythm Gade
UnaryOperatorNode
 */

public abstract class UnaryOperatorNode implements PIPCalcNode{

    protected PIPCalcNode child;
    protected String operator;
    protected Precedence precedence;

    public UnaryOperatorNode(PIPCalcNode child, String operator, Precedence precedence){
        this.child = child;
        this.operator = operator;
        this.precedence = precedence;
    }

    public void setChild(PIPCalcNode child) {
        this.child = child;
    }

    @Override
    public String toPrefixString() {
        return operator + " " + child.toPrefixString();
    }

    @Override
    public String toInfixString() {
        return "(" + operator + " " + child.toInfixString() + ")";
    }

    @Override
    public String toPostfixString() {
        return child.toPostfixString() + " " + operator;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.UnaryOperation;
    }

    public int getPrecedence(){
        return this.precedence.getPrecedence();
    }

    @Override
    public boolean isOperation() {
        return true;
    }
}
