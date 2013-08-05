package au.com.bytecode.bracketquiz;

import com.google.common.base.Charsets;
import com.google.common.base.Stopwatch;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Basic work around String operations.
 *
 * @author Glen
 */
public class BracketMatcherTester {

    @Test
    public void testParser() throws IOException {
        
        int correctLines = 0;
        int failedLines = 0;
        
        // Take IO out of the picture by slurping it all in up front
        List<String> matchingLines = Files.readLines(
                new File("src/test/resources/brackets.txt"),
                Charsets.UTF_8);
        
        final BracketMatcher bm = new YourCustomBracketMatcher();

        Stopwatch stopwatch = new Stopwatch().start();
        
        for (String nextLine : matchingLines) {
            if (bm.validateBrackets(nextLine)) {
                correctLines++;
            } else {
                failedLines++;
            }
        }
           
        stopwatch.stop();
        
        assertEquals(1000, correctLines);
        assertEquals(0, failedLines);
        System.out.printf("Completed run in %d ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }
}
