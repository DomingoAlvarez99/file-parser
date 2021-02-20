package org.dalvarez.fileparser.summary;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public final class ConsoleSummaryPrinter implements SummaryPrinter {
    @Override
    public void print(LocalDateTime startDate, String inputFileType, String outputFileType, String inputFile, String outputFile) {
        long seconds = ChronoUnit.SECONDS.between(startDate, LocalDateTime.now());
        long milis = ChronoUnit.MILLIS.between(startDate, LocalDateTime.now());

        System.out.println("Input file type: " + inputFileType);
        System.out.println("Input file: " + inputFile);
        System.out.println("Output file type: " + outputFileType);
        System.out.println("Output file: " + outputFile);
        System.out.println("Time elapsed: " + seconds + "." + milis + "s");
    }
}