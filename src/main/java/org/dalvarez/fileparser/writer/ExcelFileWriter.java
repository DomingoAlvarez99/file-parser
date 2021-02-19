package org.dalvarez.fileparser.writer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dalvarez.fileparser.exception.UnExpectedException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

final public class ExcelFileWriter implements FileWriter {
    private static final String WORKSHEET_NAME = "Default";
    private int cellCounter;
    private int rowCounter;

    @Override
    public void write(List<List<String>> fileParsed, String outputFileName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(WORKSHEET_NAME);

        fileParsed.forEach(rowList -> {
            Row row = sheet.createRow(rowCounter);

            rowList.forEach(cellString -> {
                Cell cell = row.createCell(cellCounter);
                cell.setCellValue(cellString);

                cellCounter++;
            });

            cellCounter = 0;
            rowCounter++;
        });

        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new UnExpectedException("Error while writing the file " + outputFileName);
        }
    }
}
