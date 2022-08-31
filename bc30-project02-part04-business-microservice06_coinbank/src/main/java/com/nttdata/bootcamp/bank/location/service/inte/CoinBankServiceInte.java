package com.nttdata.bootcamp.bank.location.service.inte;

import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinBankServiceInte
{

    Mono<CoinBank> create(final CoinBank location);

    Flux<CoinBank> readAll();

    Mono<CoinBank> readByCodeLocation(String codeLocation);

    Mono<CoinBank> updateById(final String id, final CoinBank location);

    Mono<Void> deleteById(final String id);
}