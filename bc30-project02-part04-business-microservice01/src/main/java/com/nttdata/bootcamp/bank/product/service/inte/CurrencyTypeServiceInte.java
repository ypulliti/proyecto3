package com.nttdata.bootcamp.bank.product.service.inte;

import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyTypeServiceInte
{

    Mono<CurrencyType> create(final CurrencyType product);

    Flux<CurrencyType> readAll();

    Mono<CurrencyType> findByCodeId(String codeProduct);

    Mono<CurrencyType> updateById(final String id, final CurrencyType product);

    Mono<Void> deleteById(final String id);
}