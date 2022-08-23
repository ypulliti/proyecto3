package com.nttdata.bootcamp.bank.product.controller;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.model.document.ProductSubTypeRule;
import com.nttdata.bootcamp.bank.product.service.impl.ProductSubTypeRuleServiceImpl;
import com.nttdata.bootcamp.bank.product.service.inte.ProductSubTypeRuleServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductSubTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductlServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productsubtyperule")
public class ProductSubTypeRuleController
{
    private static final Logger log = LoggerFactory.getLogger(ProductSubTypeRuleController.class);

    @Autowired
    private ProductSubTypeRuleServiceInte CurrencyTypeServiceInte;

    @PostMapping("create")
    public Mono<ProductSubTypeRule> create(@RequestBody final ProductSubTypeRule product) {
        log.debug("Begin RestController create Product");
        return CurrencyTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<ProductSubTypeRule> readAll() {
        log.debug("Begin RestController readAll Product");
        return CurrencyTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<ProductSubTypeRule> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return CurrencyTypeServiceInte.findByCodeId(codeProduct);
    }

    @PutMapping("update/{id}")
    public Mono<ProductSubTypeRule> updateById(@RequestBody final ProductSubTypeRule product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return CurrencyTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return CurrencyTypeServiceInte.deleteById(id);
    }

}