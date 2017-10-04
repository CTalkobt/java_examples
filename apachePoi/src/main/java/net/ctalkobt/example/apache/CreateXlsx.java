/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.ctalkobt.example.apache;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateXlsx {

    protected static void populateSheet(Sheet sheet, List<List<String>> cells) {
        int rowNum = 0;
        for (List<String> rowData : cells) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String val : rowData) {
                row.createCell(cellNum++).setCellValue(val);
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<List<String>> cellData = new ArrayList<>();
        for (int row=1; row <= 12; row++) {
            List<String> rowData = new ArrayList<>();
            for (int cell = 1; cell <= 12; cell++) {
                rowData.add("" + cell*row);
            }
            cellData.add(rowData);
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample");

        populateSheet(sheet, cellData);

        String filename = "createExcelXlsx.xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
            workbook.write(fileOut);
        }
    }
}
