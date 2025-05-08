package org.example.loganalyzer;

import java.util.List;
import java.util.Map;

public class LogSummary {
    private final int uniqueIpCount;
    private final List<Map.Entry<String, Integer>> topMostIps;
    private final List<Map.Entry<String, Integer>> topMostUrls;

    public LogSummary(int uniqueIpCount,
                     List<Map.Entry<String, Integer>> topMostIps,
                     List<Map.Entry<String, Integer>> topMostUrls) {
        this.uniqueIpCount = uniqueIpCount;
        this.topMostIps = topMostIps;
        this.topMostUrls = topMostUrls;

    }

    public int getUniqueIpCount() {
        return uniqueIpCount;
    }

    public List<Map.Entry<String, Integer>> getTopMostIps() {
        return topMostIps;
    }

    public List<Map.Entry<String, Integer>> getTopMostUrls() {
        return topMostUrls;
    }
}
