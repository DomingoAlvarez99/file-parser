package org.dalvarez.fileparser.parser;

import org.dalvarez.fileparser.reader.FileReader;
import org.dalvarez.fileparser.writer.FileWriter;

import java.util.List;

public final class FileParser {
    private final FileReader<List<List<String>>> fileReader;
    private final FileWriter fileWriter;

    public FileParser(FileReader<List<List<String>>> fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public void parse(String inputFileName, String outputFileName) {
        List<List<String>> fileParsed = fileReader.read(inputFileName);
        fileWriter.write(fileParsed, outputFileName);
    }
}
