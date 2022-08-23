package com.nttdata.bootcamp.bank.product.controller;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubTypeRule;
import com.nttdata.bootcamp.bank.product.model.document.Rule;
import com.nttdata.bootcamp.bank.product.service.impl.RuleServiceImpl;
import com.nttdata.bootcamp.bank.product.service.inte.ProductSubTypeRuleServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.RuleServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rulecontroller")
public class RuleController
{
    private static final Logger log = LoggerFactory.getLogger(RuleController.class);

    @Autowired
    private RuleServiceInte CurrencyTypeServiceInte;

    @PostMapping("create")
    public Mono<Rule> create(@RequestBody final Rule product) {
        log.debug("Begin RestController create Product");
        return CurrencyTypeServiceInte.create(product);
    }

    @GetMapping
    public Flux<Rule> readAll() {
        log.debug("Begin RestController readAll Product");
        return CurrencyTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<Rule> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return CurrencyTypeServiceInte.findById(codeProduct);
    }

    @PutMapping("update/{id}")
    public Mono<Rule> updateById(@RequestBody final Rule product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return CurrencyTypeServiceInte.updateById(id, product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return CurrencyTypeServiceInte.deleteById(id);
    }

}