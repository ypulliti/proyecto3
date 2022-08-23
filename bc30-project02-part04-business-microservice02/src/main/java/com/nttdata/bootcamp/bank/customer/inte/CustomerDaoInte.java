package com.nttdata.bootcamp.bank.customer.inte;

import com.nttdata.bootcamp.bank.customer.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerDaoInte extends ReactiveMongoRepository<Customer, String> {

}
