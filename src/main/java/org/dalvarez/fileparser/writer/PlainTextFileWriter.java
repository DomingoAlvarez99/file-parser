package org.dalvarez.fileparser.writer;

import org.dalvarez.fileparser.exception.UnExpectedException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

final public class PlainTextFileWriter implements FileWriter {
    private static final String COLUMN_SEPARATOR = ";";

    @Override
    public void write(List<List<String>> fileParsed, String outputFileName) {
        List<String> rows = fileParsed.stream()
                .map(row -> String.join(COLUMN_SEPARATOR, row))
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get(outputFileName), rows, Charset.defaultCharset());
        } catch (IOException e) {
            throw new UnExpectedException("Error while writing the file " + outputFileName);
        }
    }
}
