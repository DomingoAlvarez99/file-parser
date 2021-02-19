package org.dalvarez.fileparser.summary;

import java.time.LocalDateTime;

public interface SummaryPrinter {
    void print(LocalDateTime startDate, String inputFileType, String outputFileType, String inputFile, String outputFile);
}
