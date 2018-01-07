package processors;

import nodes.BinaryOperatorNode;
import nodes.PIPCalcNode;
import nodes.UnaryOperatorNode;

import java.util.ArrayList;
import java.util.Stack;

/*Rythm Gade
PIPCalcPostfixProcessor
 */

public class PIPCalcPostfixProcessor extends PIPCalcProcessor {
    //builds tree using reverse polish
    @Override
    public void constructTree(ArrayList<String> tokens) {

        Stack<PIPCalcNode> opst = new Stack<PIPCalcNode>();
        PIPCalcNode t1, t2;

        for (String s : tokens){
            if (PIPCalcProcessor.isNumeric(s)){
                opst.push(createPIPCalcNode(s));
            }

            else {
                PIPCalcNode t = createPIPCalcNode(s);

                if(t instanceof BinaryOperatorNode){
                    t1 = opst.pop();
                    t2 = opst.pop();
                    ((BinaryOperatorNode) t).setRightChild(t1);
                    ((BinaryOperatorNode) t).setLeftChild(t2);

                }

                else if(t instanceof UnaryOperatorNode){
                    t2 = opst.pop();
                    ((UnaryOperatorNode) t).setChild(t2);

                }

                opst.push(t);
            }


            }

            tree = opst.pop();
        }

}
