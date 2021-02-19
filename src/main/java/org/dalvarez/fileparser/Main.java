package org.dalvarez.fileparser;

import org.dalvarez.fileparser.context.Context;
import org.dalvarez.fileparser.parser.FileParser;
import org.dalvarez.fileparser.summary.ConsoleSummaryPrinter;
import org.dalvarez.fileparser.summary.SummaryPrinter;

import java.time.LocalDateTime;

final public class Main {
    public static void main(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("There must be 4 arguments");
        }

        LocalDateTime startDate = LocalDateTime.now();

        final String inputFileType = args[0];
        final String outputFileType = args[2];

        Context context = new Context(inputFileType, outputFileType);

        final String inputFileName = args[1];
        final String outputFileName = args[3];

        new FileParser(context.getFileReader(), context.getFileWriter())
                .parse(inputFileName, outputFileName);

        SummaryPrinter summaryPrinter = new ConsoleSummaryPrinter();
        summaryPrinter.print(startDate, inputFileType, outputFileType, inputFileName, outputFileName);
    }
}
