package processors;

import nodes.BinaryOperatorNode;
import nodes.ConstantNode;
import nodes.PIPCalcNode;
import nodes.UnaryOperatorNode;

import java.util.*;
/*Rythm Gade
PIPCalcPrefixProcessor
 */

public class PIPCalcPrefixProcessor extends PIPCalcProcessor {

    //builds tree using polish notation, with reversed list

    @Override
    public void constructTree(ArrayList<String> tokens) {
        Collections.reverse(tokens);
        Stack<PIPCalcNode> opst = new Stack<>();
        PIPCalcNode t1, t2;

        for (String s : tokens){
            if (!PIPCalcProcessor.isNumeric(s)){
                PIPCalcNode t = createPIPCalcNode(s);
                if(t instanceof BinaryOperatorNode){
                    t1 = opst.pop();
                    t2 = opst.pop();
                    ((BinaryOperatorNode) t).setLeftChild(t1);
                    ((BinaryOperatorNode) t).setRightChild(t2);

                }

                else if(t instanceof UnaryOperatorNode){
                    t2 = opst.pop();
                    ((UnaryOperatorNode) t).setChild(t2);

                }

                opst.add(t);
            }

            else {
                opst.push(createPIPCalcNode(s));
            }


        }

        tree = opst.pop();
    }
}
