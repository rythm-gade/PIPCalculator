package processors;

import nodes.BinaryOperatorNode;
import nodes.PIPCalcNode;
import nodes.Precedence;
import nodes.UnaryOperatorNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*Rythm Gade
PIPCalcInfixProcessor
 */

public class PIPCalcInfixProcessor extends PIPCalcProcessor {
    //builds tree using Shunting Yard alg
    @Override
    public void constructTree(ArrayList<String> tokens) {
        LinkedList<PIPCalcNode> output = new LinkedList<>();
        Stack<PIPCalcNode> opst = new Stack<>();
        PIPCalcNode t1, t2, t3, t4;

        for (String s : tokens){
            if (PIPCalcProcessor.isNumeric(s)){
                PIPCalcNode t = createPIPCalcNode(s);
                output.add(t);
            }

            else {
                PIPCalcNode t = createPIPCalcNode(s);
                if (!opst.empty()){
                    if (opst.peek().getPrecedence() <= t.getPrecedence()) {
                        t1 = opst.pop();
                        opst.add(t);
                        if(t1 instanceof BinaryOperatorNode){
                            t3 = output.remove();
                            t4 = output.remove();
                            ((BinaryOperatorNode) t1).setLeftChild(t3);
                            ((BinaryOperatorNode) t1).setRightChild(t4);
                            output.add(t1);

                        }

                        else if(t1 instanceof UnaryOperatorNode){
                            t3 = output.remove();
                            ((UnaryOperatorNode) t1).setChild(t3);
                            output.add(t1);
                        }

                    }

                    else{
                        opst.add(t);
                    }

                }
                else{
                    opst.add(t);
                }

            }

        }

        while (!opst.empty()){
            t1 = opst.pop();
            if(t1 instanceof BinaryOperatorNode){
                t2 = output.removeLast();
                t3 = output.removeLast();
                ((BinaryOperatorNode) t1).setLeftChild(t3);
                ((BinaryOperatorNode) t1).setRightChild(t2);
                output.add(t1);

            }

            else if(t1 instanceof UnaryOperatorNode){
                t3 = output.remove();
                ((UnaryOperatorNode) t1).setChild(t3);
                output.add(t1);

            }

        }

       tree = output.pop();
    }
}
