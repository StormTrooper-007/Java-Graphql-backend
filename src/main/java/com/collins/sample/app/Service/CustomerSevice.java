package com.collins.sample.app.Service;


import com.collins.sample.app.Models.Customer;
import com.collins.sample.app.Repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerSevice {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> AllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> SingleCustomer(ObjectId id){
        return customerRepository.findById(id);
    }
}
