import org.example.loganalyzer.LogAnalyzer;
import org.example.loganalyzer.LogSummary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogAnalyzerTest {
    LogAnalyzer logAnalyzer;


    @Test
    void testLogAnalyzer() throws IOException{
        logAnalyzer = new LogAnalyzer();
        LogSummary logSummary= logAnalyzer.analyze("programming-task-example-data.log");

       //test unique IP count
        assertEquals(11, logSummary.getUniqueIpCount());

        //test topMostIps
        assertEquals("50.112.00.11", logSummary.getTopMostIps().get(1).getKey());

        //test topMostUrls
        assertEquals("/docs/manage-websites/", logSummary.getTopMostUrls().get(0).getKey());

    }

}
