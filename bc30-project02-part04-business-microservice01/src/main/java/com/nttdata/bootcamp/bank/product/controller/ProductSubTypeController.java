package com.nttdata.bootcamp.bank.product.controller;

import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.service.impl.ProductSubTypeServiceImpl;
import com.nttdata.bootcamp.bank.product.service.inte.CurrencyTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductSubTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductlServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productsubtype")
public class ProductSubTypeController
{
    private static final Logger log = LoggerFactory.getLogger(ProductlServiceInte.class);

    @Autowired
    private ProductSubTypeServiceInte CurrencyTypeServiceInte;

    @PostMapping("create")
    public Mono<ProductSubType> create(@RequestBody final ProductSubType product) {
        log.debug("Begin RestController create Product");
        return CurrencyTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<ProductSubType> readAll() {
        log.debug("Begin RestController readAll Product");
        return CurrencyTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductSubType> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return CurrencyTypeServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("update/{id}")
    public Mono<ProductSubType> updateById(@RequestBody final ProductSubType product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return CurrencyTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return CurrencyTypeServiceInte.deleteById(id);
    }

}