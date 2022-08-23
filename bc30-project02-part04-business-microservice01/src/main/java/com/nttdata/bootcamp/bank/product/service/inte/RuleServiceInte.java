package com.nttdata.bootcamp.bank.product.service.inte;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.model.document.Rule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RuleServiceInte
{

    Mono<Rule> create(final Rule product);

    Flux<Rule> readAll();

    Mono<Rule> findById(String codeProduct);

    Mono<Rule> updateById(final String id, final Rule product);

    Mono<Void> deleteById(final String id);
}