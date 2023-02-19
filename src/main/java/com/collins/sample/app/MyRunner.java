package com.collins.sample.app;

import com.collins.sample.app.Models.Customer;
import com.collins.sample.app.Repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerRepository customerRepository;

    public MyRunner(CustomerRepository customerRepository){
        this.customerRepository =  customerRepository;
    }
    @Override
    public void run(String... args){
        customerRepository.deleteAll();
        customerRepository.save(new Customer(new ObjectId(),"Collins",
                "Chigbo", "chigbo.c.o@gmail.com", "1234", "Munich" ));
        customerRepository.save(new Customer(new ObjectId(),"Antonia",
                "Chigbo","antonia.k.@gmail.com", "12348848484", "Basel" ));
        customerRepository.save(new Customer(new ObjectId(),"Guthold",
                "Francis","guthold@gmail.com", "44884898393", "Los angeles" ));
        customerRepository.save(new Customer(new ObjectId(),"Ursula",
                "kingsley","ursula@gmail.com", "44748382993", "Nevada" ));
        logger.info("returning customers");
    }
}
