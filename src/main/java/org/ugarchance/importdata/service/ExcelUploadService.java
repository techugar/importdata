package org.ugarchance.importdata.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.ugarchance.importdata.domain.Customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file) {

        //checked is file excel
        return Objects.equals(file.getContentType(),
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Customer> getCustomerDataFromExcel(InputStream inputStream) throws IOException {
        List<Customer> customers = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        //excel sheet name
        XSSFSheet sheet = workbook.getSheet("Customers");

        int rowIndex = 0;
        for (Row row : sheet) {

            if (rowIndex == 0) {
                rowIndex++;
                continue;
            }

            Iterator<Cell> cellIterator = row.iterator();
            int cellIndex = 0;

            Customer customer = new Customer();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cellIndex) {

                    case 0 -> customer
                            .setCustomerID((int) cell.getNumericCellValue());
                    case 1 -> customer
                            .setFirstName(cell.getStringCellValue());
                    case 2 -> customer
                            .setLastName(cell.getStringCellValue());
                    case 3 -> customer
                            .setCountry(cell.getStringCellValue());
                    case 4 -> customer
                            .setTelephone((int) cell.getNumericCellValue());
                    default -> {

                    }

                }
                cellIndex++;

            }
            customers.add(customer);

        }


        return customers;
    }


}
