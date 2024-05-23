package org.ugarchance.importdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugarchance.importdata.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
