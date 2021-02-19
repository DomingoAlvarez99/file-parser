package org.dalvarez.fileparser.reader;

public interface FileReader<T> {
    T read(String fileName);
}
