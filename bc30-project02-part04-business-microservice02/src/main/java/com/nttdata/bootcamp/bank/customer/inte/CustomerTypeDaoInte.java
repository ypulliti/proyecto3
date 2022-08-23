package com.nttdata.bootcamp.bank.customer.inte;


import com.nttdata.bootcamp.bank.customer.document.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerTypeDaoInte extends ReactiveMongoRepository<CustomerType, String> {

    Mono<CustomerType> readByCodeCustomerType(String codeCustomerType);

}
