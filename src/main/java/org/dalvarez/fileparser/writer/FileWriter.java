package org.dalvarez.fileparser.writer;

import java.util.List;

public interface FileWriter {
    void write(List<List<String>> fileParsed, String outputFileName);
}
