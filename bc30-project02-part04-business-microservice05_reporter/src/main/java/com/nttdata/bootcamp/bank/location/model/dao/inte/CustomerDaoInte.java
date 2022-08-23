package com.nttdata.bootcamp.bank.location.model.dao.inte;

import com.nttdata.bootcamp.bank.location.model.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerDaoInte extends ReactiveMongoRepository<Customer, String> {

    Mono<Customer> readByCodeCustomer(String codeCustomer);
}
