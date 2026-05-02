package com.tutorialsninja.utility;



import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    // ✅ Dynamic project path (works everywhere)
    private static final String path =
            System.getProperty("user.dir")
            + "/src/test/resources/TestData/TestData.xlsx";

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    // ✅ Load sheet once
    public static void loadSheet(String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            // 🔥 Important validation
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Get total rows
    public static int getRowCount() {
        if (sheet == null) {
            throw new RuntimeException("Sheet not loaded. Call loadSheet() first.");
        }
        return sheet.getLastRowNum() + 1;
    }

    // ✅ Get total columns
    public static int getColumnCount() {
        if (sheet == null) {
            throw new RuntimeException("Sheet not loaded. Call loadSheet() first.");
        }
        return sheet.getRow(0).getLastCellNum();
    }

    // ✅ SAFE method (handles null rows + cells)
    public static String getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();

        if (sheet == null) {
            throw new RuntimeException("Sheet not loaded. Call loadSheet() first.");
        }

        // 🔴 Handle null row
        if (sheet.getRow(rowNum) == null) {
            return "";
        }

        // 🔴 Handle null cell
        if (sheet.getRow(rowNum).getCell(colNum) == null) {
            return "";
        }

        return formatter.formatCellValue(
                sheet.getRow(rowNum).getCell(colNum));
    }

}