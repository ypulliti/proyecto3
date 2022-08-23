package com.nttdata.bootcamp.bank.product.controller;

import com.nttdata.bootcamp.bank.product.model.document.Product;
import com.nttdata.bootcamp.bank.product.service.impl.ProductServiceImpl;
import com.nttdata.bootcamp.bank.product.service.inte.ProductlServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private static final Logger log = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductlServiceInte productServiceInte;

    @PostMapping("create")
    public Mono<Product> create(@RequestBody final Product product) {
        log.debug("Begin RestController create Product");
        return productServiceInte.create(product);
    }

    @GetMapping
    public Flux<Product> readAll() {
        log.debug("Begin RestController readAll Product");
        return productServiceInte.readAll();
    }

    @GetMapping("findByCode/{codeProduct}")
    public Mono<Product> findByCodeProduct(@PathVariable String codeProduct) {
        log.debug("Begin RestController findByCodeProduct Product");
        return productServiceInte.findByCodeProduct(codeProduct);
    }

    @PutMapping("update/{id}")
    public Mono<Product> updateById(@RequestBody final Product product, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Product");
        return productServiceInte.updateById(id, product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Product");
        return productServiceInte.deleteById(id);
    }

}