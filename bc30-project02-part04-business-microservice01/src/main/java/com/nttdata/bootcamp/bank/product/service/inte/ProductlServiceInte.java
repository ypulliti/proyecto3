package com.nttdata.bootcamp.bank.product.service.inte;

import com.nttdata.bootcamp.bank.product.model.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductlServiceInte {

    Mono<Product> create(final Product product);

    Flux<Product> readAll();

    Mono<Product> findByCodeProduct(String codeProduct);

    Mono<Product> updateById(final String id, final Product product);

    Mono<Void> deleteById(final String id);
}