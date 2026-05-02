package com.tutorialsninja.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.tutorialsninja.utility.ExcelUtils;

public class DataProviders {

    private static final String sheetName = "loginData";

    @DataProvider(name = "loginData")
    public Object[][] getEmailData() {

        // ✅ Load Excel
        ExcelUtils.loadSheet(sheetName);

        int rows = ExcelUtils.getRowCount();

        List<Object[]> list = new ArrayList<>();

        // ✅ Start from 1 (skip header)
        for (int i = 1; i < rows; i++) {

            String username = ExcelUtils.getCellData(i, 0);
            String password = ExcelUtils.getCellData(i, 1);

            // ✅ Skip empty rows
            if (username.isEmpty() && password.isEmpty()) {
                continue;
            }

            list.add(new Object[]{username, password});
        }

        return list.toArray(new Object[0][]);
    }
}