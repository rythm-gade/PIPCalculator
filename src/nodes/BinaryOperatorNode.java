
package nodes;

/*Rythm Gade
BinaryOperatorNode
 */

public abstract class BinaryOperatorNode implements PIPCalcNode {

    protected PIPCalcNode leftChild;
    protected String operator;
    protected Precedence precedence;
    protected PIPCalcNode rightChild;

    public BinaryOperatorNode(PIPCalcNode leftChild, PIPCalcNode rightChild, Precedence precedence, String operator){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    public void setLeftChild(PIPCalcNode leftChild){
        this.leftChild = leftChild;
    }

    public void setRightChild(PIPCalcNode rightChild){
        this.rightChild = rightChild;
    }

    @Override
    public String toPrefixString() {
        return  operator + " "  + leftChild.toPrefixString() + " " + rightChild.toPrefixString();
    }

    @Override
    public String toInfixString() {
        return "(" + leftChild.toInfixString() +  " " + operator + " "  + rightChild.toInfixString() + ")";
    }

    @Override
    public String toPostfixString() {
        return leftChild.toPostfixString() + " " + rightChild.toPostfixString() + " " + operator;
    }

    @Override
    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }

    @Override
    public boolean isOperation() {
        return true;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.BinaryOperation;
    }

    @Override
    public String toString() {
        return leftChild.toString() + operator + rightChild.toString();
    }
}
