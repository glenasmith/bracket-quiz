package au.com.bytecode.bracketquiz;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Stack;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * Simple Bracket Generator for well formed matching brackets.
 * 
 * @author Glen
 */
public class BracketGeneratorTest {

    @Ignore
    @Test
    public void buildSampleFile() throws IOException {
        
        final int ITERATIONS = 1000;
        final int MAX_SIZE_BEFORE_CLOSING_OFF = 200;
        
        final char START_CHAR = '(';
        final char END_CHAR = ')';
        final String outFilename = "src/test/resources/brackets.txt";
        
        PrintStream ps = new PrintStream(new File(outFilename));

        Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < ITERATIONS; i++) {
            int minSize = rnd.nextInt(MAX_SIZE_BEFORE_CLOSING_OFF);
            boolean done = false;
            Stack<Character> s = new Stack<Character>();
            StringBuilder sb = new StringBuilder();
            while (!done) {
                boolean nextIsOpening; 
                if (s.size() == 0) {
                    nextIsOpening = true; 
                } else {
                    nextIsOpening = rnd.nextBoolean();
                }
                if (nextIsOpening) {
                    s.add(START_CHAR);
                    sb.append(START_CHAR);
                } else {
                    s.pop();
                    sb.append(END_CHAR);
                }
                if (sb.length() > minSize) {
                    done = true;
                } 
                
            }
            while (!s.isEmpty()) {
                s.pop();
                sb.append(END_CHAR);
            }
            ps.println(sb.toString());
            System.out.println(sb.toString());

        }
        System.out.println("All Done\n\n\n");
    }

    
}