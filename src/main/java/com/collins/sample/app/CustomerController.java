package com.collins.sample.app;

import com.collins.sample.app.Models.Customer;
import com.collins.sample.app.Repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
    @QueryMapping
    public Customer customerById(@Argument ObjectId id){
        return customerRepository.findById(id).orElseThrow();
    }
    @QueryMapping
    public Customer customerByEmail(@Argument String email){
        return customerRepository.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument String firstname,
                                @Argument String lastname,
                                @Argument String email,
                                @Argument String phone,
                                @Argument String city){
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setCity(city);

        customerRepository.save(customer);
        return customer;
    }
}
