package org.ugarchance.importdata.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    private Integer customerID;
    private String firstName;
    private String lastName;
    private String country;
    private Integer telephone;


}
