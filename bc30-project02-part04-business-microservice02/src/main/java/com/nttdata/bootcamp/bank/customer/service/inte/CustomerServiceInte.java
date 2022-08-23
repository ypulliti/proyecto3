package com.nttdata.bootcamp.bank.customer.service.inte;

import com.nttdata.bootcamp.bank.customer.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerServiceInte
{

    Mono<Customer> create(final Customer customer);

    Flux<Customer> readAll();

    Mono<Customer> readByCodeCustomer(String codeCustomer);

    Mono<Customer> updateById(final String id, final Customer customer);

    Mono<Void> deleteById(final String id);
}