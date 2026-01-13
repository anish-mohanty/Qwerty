package com.cognizant.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    protected long accountNo;
    protected FullName fullName;
    protected Address address;
    protected long contactNo;
    protected String email;
    protected String password;

}
