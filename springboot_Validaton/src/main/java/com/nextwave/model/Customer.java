package com.nextwave.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Size(min = 2, message = "First Name should be more than 2 character")
    private String custName;

    private String custAddress;

    private long custContactNumber;

    private double custAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @NotNull
    @Email(message = "Email should be valid")
    private String custEmailId;

    @NotNull
    @Size(min = 4, message = "Password at least 4 character")
    private String custPassword;

}
