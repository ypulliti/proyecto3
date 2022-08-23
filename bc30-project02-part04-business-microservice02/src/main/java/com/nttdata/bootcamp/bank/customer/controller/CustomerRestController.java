package com.nttdata.bootcamp.bank.customer.controller;

import com.nttdata.bootcamp.bank.customer.document.Customer;
import com.nttdata.bootcamp.bank.customer.service.impl.CustomerServiceImpl;
import com.nttdata.bootcamp.bank.customer.service.inte.CustomerServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController
{

    private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    @Autowired
    private CustomerServiceImpl customerServiceInte;

    @PostMapping("create")
    public Mono<Customer> create(@RequestBody final Customer customer) {
        log.debug("Begin RestController create Customer");
        return customerServiceInte.create(customer);
    }

    @GetMapping
    public Flux<Customer> readAll() {
        log.debug("Begin RestController readAll Customer");
        return customerServiceInte.readAll();
    }

    @GetMapping("readByCodeCustomer/{codeCustomer}")
    public Mono<Customer> readByCodeCustomer(@PathVariable String codeCustomer) {
        log.debug("Begin RestController readByCodeCustomer Customer");
        return customerServiceInte.readByCodeCustomer(codeCustomer);
    }

    @PutMapping("updateById/{id}")
    public Mono<Customer> updateById(@RequestBody final Customer customer, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Customer");
        return customerServiceInte.updateById(id, customer);
    }

    @DeleteMapping("deleteById/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Customer");
        return customerServiceInte.deleteById(id);
    }

}