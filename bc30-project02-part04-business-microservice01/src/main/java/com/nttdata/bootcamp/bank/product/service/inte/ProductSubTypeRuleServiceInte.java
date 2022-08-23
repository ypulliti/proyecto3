package com.nttdata.bootcamp.bank.product.service.inte;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.model.document.ProductSubTypeRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductSubTypeRuleServiceInte
{

    Mono<ProductSubTypeRule> create(final ProductSubTypeRule product);

    Flux<ProductSubTypeRule> readAll();

    Mono<ProductSubTypeRule> findByCodeId(String codeProduct);

    Mono<ProductSubTypeRule> updateById(final String id, final ProductSubTypeRule product);

    Mono<Void> deleteById(final String id);
}