package com.nttdata.bootcamp.bank.customer.controller;

import com.nttdata.bootcamp.bank.customer.document.CustomerType;
import com.nttdata.bootcamp.bank.customer.service.impl.CustomerTypeServiceImpl;
import com.nttdata.bootcamp.bank.customer.service.inte.CustomerTypeServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customertypes")
public class CustomerTypeRestController
{

    private static final Logger log = LoggerFactory.getLogger(CustomerTypeRestController.class);

    @Autowired
    private CustomerTypeServiceImpl customerTypeServiceInte;

    @PostMapping("create")
    public Mono<CustomerType> create(@RequestBody final CustomerType customerType) {
        log.debug("Begin RestController create CustomerType");
        return customerTypeServiceInte.create(customerType);
    }

    @GetMapping
    public Flux<CustomerType> readAll() {
        log.debug("Begin RestController readAll CustomerType");
        return customerTypeServiceInte.readAll();
    }

    @GetMapping("readByCodeCustomerType/{codeCustomerType}")
    public Mono<CustomerType> readByCodeCustomerType(@PathVariable String codeCustomerType) {
        log.debug("Begin RestController readByCodeCustomerType CustomerType");
        return customerTypeServiceInte.readByCodeCustomerType(codeCustomerType);
    }

    @PutMapping("updateById/{id}")
    public Mono<CustomerType> updateById(@RequestBody final CustomerType customerType, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById CustomerType");
        return customerTypeServiceInte.updateById(id, customerType);
    }

    @DeleteMapping("deleteById/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById CustomerType");
        return customerTypeServiceInte.deleteById(id);
    }

}