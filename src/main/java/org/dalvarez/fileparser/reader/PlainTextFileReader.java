package org.dalvarez.fileparser.reader;

import org.dalvarez.fileparser.exception.FileNotFoundException;
import org.dalvarez.fileparser.exception.UnExpectedException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class PlainTextFileReader implements FileReader<List<List<String>>> {
    private static final String COLUMN_SEPARATOR = ";";

    @Override
    public List<List<String>> read(String fileName) {
        try {
            return Files.lines(Paths.get(fileName))
                    .map(line -> Arrays.stream(line.split(COLUMN_SEPARATOR))
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());
        } catch (java.io.FileNotFoundException e) {
            throw new FileNotFoundException("File not found " + fileName);
        } catch (Exception e) {
            throw new UnExpectedException("An error occurred while reading the file " + fileName);
        }
    }
}
