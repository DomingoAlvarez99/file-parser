package org.dalvarez.fileparser.context;

import org.dalvarez.fileparser.reader.FileReader;
import org.dalvarez.fileparser.writer.FileWriter;

import java.util.List;

final public class Context {
    private FileType inputFileType;

    private FileType outputFileType;

    public Context(String inputFileTypeName, String outputFileTypeName) {
        this.inputFileType = FileType.fromString(inputFileTypeName);
        this.outputFileType = FileType.fromString(outputFileTypeName);
    }

    public FileReader<List<List<String>>> getFileReader() {
        return inputFileType.getFileReader();
    }

    public FileWriter getFileWriter() {
        return outputFileType.getFileWriter();
    }
}
