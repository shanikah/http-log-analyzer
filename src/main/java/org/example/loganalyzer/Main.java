package org.example.loganalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            //read filePath as an argument
            if (args.length == 0) {
                System.out.println("Please provide the log file path as an argument.");
                return;
            }
            String logFilePath = args[0];
            //String logFilePath = "programming-task-example-data.log";
            LogAnalyzer logAnalyzer = new LogAnalyzer();
            LogSummary logSummary = logAnalyzer.analyze(logFilePath);

            //printIpCount
            System.out.println("\nUnique IP address Count:" + logSummary.getUniqueIpCount());

            //print Top 3 Ips
            System.out.println("\nTop 3 most active Ips:");
            logSummary.getTopMostIps().forEach(entry -> System.out.println("\t"+entry.getKey()));

            //Print Top 3 Urls
            System.out.println("\nTop 3 most visited Urls:");
            logSummary.getTopMostUrls().forEach(entry -> System.out.println("\t"+entry.getKey()));

        }catch (IOException e) {
            System.err.println("File Processing Error:"+e.getMessage());
        }

    }
}