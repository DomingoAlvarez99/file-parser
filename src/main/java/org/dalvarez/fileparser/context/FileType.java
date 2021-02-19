package org.dalvarez.fileparser.context;

import org.dalvarez.fileparser.exception.IllegalArgumentException;
import org.dalvarez.fileparser.reader.ExcelFileReader;
import org.dalvarez.fileparser.reader.FileReader;
import org.dalvarez.fileparser.reader.PlainTextFileReader;
import org.dalvarez.fileparser.writer.ExcelFileWriter;
import org.dalvarez.fileparser.writer.FileWriter;
import org.dalvarez.fileparser.writer.PlainTextFileWriter;

import java.util.List;

public enum FileType {
    PLAIN_TEXT(new PlainTextFileReader(), new PlainTextFileWriter()),
    EXCEL(new ExcelFileReader(), new ExcelFileWriter());

    private final FileReader<List<List<String>>> fileReader;
    private final FileWriter fileWriter;

    FileType(FileReader<List<List<String>>> fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public static FileType fromString(String name) {
        try {
            return FileType.valueOf(name.toUpperCase());
        } catch (java.lang.IllegalArgumentException exception) {
            throw new IllegalArgumentException("File type not found: " + name);
        }
    }

    public FileReader<List<List<String>>> getFileReader() {
        return fileReader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }
}
