package org.example.loganalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogAnalyzer {
    private static final Pattern LOG_PATTERN = Pattern.compile( "^([\\d.]+).*?\"(?:GET|POST|PUT|DELETE|HEAD|OPTIONS)\\s+(\\S+).*");

    public LogSummary analyze(String filePath) throws IOException {

        Set<String> uniqueIps = new HashSet<String>();
        Map<String, Integer> ipCounts = new HashMap<>();
        Map<String, Integer> urlCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = LOG_PATTERN.matcher(line);
                if (matcher.matches()) {
                    String ip = matcher.group(1);
                    String url = matcher.group(2);

                    //add unique ips
                    uniqueIps.add(ip);
                    //add or update ip counts
                    ipCounts.put(ip, ipCounts.getOrDefault(ip, 0) + 1);
                    //add or update url counts
                    urlCounts.put(url, urlCounts.getOrDefault(url, 0) + 1);
                }
            }
        }
        // return logSummary
        return new LogSummary(uniqueIps.size(), findTopRecords(ipCounts, 3), findTopRecords(urlCounts,3));
    }


    private List<Map.Entry<String, Integer>> findTopRecords(Map<String, Integer> map , int limit){
        return map.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).limit(limit).collect(Collectors.toList());
    }

}
