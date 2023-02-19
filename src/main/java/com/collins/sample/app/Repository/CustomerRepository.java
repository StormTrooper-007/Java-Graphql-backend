package com.collins.sample.app.Repository;

import com.collins.sample.app.Models.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {
   Customer findCustomerByEmail(String email);
}
