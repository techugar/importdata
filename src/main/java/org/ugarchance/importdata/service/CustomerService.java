package org.ugarchance.importdata.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ugarchance.importdata.domain.Customer;
import org.ugarchance.importdata.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void saveCustomersToDatabase(MultipartFile file) {

        if (ExcelUploadService.isValidExcelFile(file)) {
            List<Customer> customers = null;
            try {
                customers = ExcelUploadService.getCustomerDataFromExcel(file.getInputStream());

                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The File is not a valid excel file");
            }
        }
    }
    public List<Customer> getCustomers() {
        return  customerRepository.findAll();

    }


}
