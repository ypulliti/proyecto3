package com.nttdata.bootcamp.bank.product.controller;

import com.nttdata.bootcamp.bank.product.model.dao.inte.CurrencyTypeDaoInte;
import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.Product;
import com.nttdata.bootcamp.bank.product.service.impl.CurrencyTypeServiceImpl;
import com.nttdata.bootcamp.bank.product.service.inte.CurrencyTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductlServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/currencytype")
public class CurrencyTypeController
{
    private static final Logger log = LoggerFactory.getLogger(CurrencyTypeController.class);

    @Autowired
    private CurrencyTypeServiceInte CurrencyTypeServiceInte;

    @PostMapping("create")
    public Mono<CurrencyType> create(@RequestBody final CurrencyType product) {
        log.debug("Begin RestController create Product");
        return CurrencyTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<CurrencyType> readAll() {
        log.debug("Begin RestController readAll Product");
        return CurrencyTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<CurrencyType> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return CurrencyTypeServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("update/{id}")
    public Mono<CurrencyType> updateById(@RequestBody final CurrencyType product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return CurrencyTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return CurrencyTypeServiceInte.deleteById(id);
    }

}