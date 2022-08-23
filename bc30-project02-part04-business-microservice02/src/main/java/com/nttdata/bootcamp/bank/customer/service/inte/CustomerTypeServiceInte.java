package com.nttdata.bootcamp.bank.customer.service.inte;

import com.nttdata.bootcamp.bank.customer.document.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerTypeServiceInte
{

    Mono<CustomerType> create(final CustomerType customerType);

    Flux<CustomerType> readAll();

    Mono<CustomerType> readByCodeCustomerType(String codeCustomerType);

    Mono<CustomerType> updateById(final String id, final CustomerType customerType);

    Mono<Void> deleteById(final String id);
}