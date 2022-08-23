package com.nttdata.bootcamp.bank.product.service.inte;

import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductSubTypeServiceInte
{

    Mono<ProductSubType> create(final ProductSubType product);

    Flux<ProductSubType> readAll();

    Mono<ProductSubType> findByCodeId(String codeProduct);

    Mono<ProductSubType> updateById(final String id, final ProductSubType product);

    Mono<Void> deleteById(final String id);
}