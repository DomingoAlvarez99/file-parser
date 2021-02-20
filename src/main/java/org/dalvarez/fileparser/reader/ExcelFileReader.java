package org.dalvarez.fileparser.reader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.dalvarez.fileparser.exception.FileNotFoundException;
import org.dalvarez.fileparser.exception.UnExpectedException;

import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class ExcelFileReader implements FileReader<List<List<String>>> {
    private static final int SHEET_INDEX = 0;

    @Override
    public List<List<String>> read(String fileName) {
        Workbook workbook;

        try {
            workbook = WorkbookFactory.create(new FileInputStream(fileName));
        } catch (java.io.FileNotFoundException e) {
            throw new FileNotFoundException("File not found " + fileName);
        } catch (Exception e) {
            throw new UnExpectedException("An error occurred while reading the file " + fileName);
        }

        Sheet sheet = workbook.getSheetAt(SHEET_INDEX);

        return StreamSupport.stream(sheet.spliterator(), false)
                .map(row -> StreamSupport.stream(row.spliterator(), false)
                        .map(cell -> cell.toString().trim())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
