import nodes.*;
import processors.PIPCalcInfixProcessor;
import processors.PIPCalcPostfixProcessor;
import processors.PIPCalcPrefixProcessor;
import processors.PIPCalcProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PIPCalcInfixProcessor processor = new PIPCalcInfixProcessor();
        ArrayList<String> aL = new ArrayList<String>(Arrays.asList(args));
        processor.constructTree(aL);
        PIPCalcNode n = processor.getTree();
        System.out.println(n.evaluate());
        System.out.println(n.toInfixString());
        System.out.println(n.toPostfixString());
        System.out.println(n.toPrefixString());
    }
}
