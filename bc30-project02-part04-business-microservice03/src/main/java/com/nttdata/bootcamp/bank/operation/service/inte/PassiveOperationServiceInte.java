package com.nttdata.bootcamp.bank.operation.service.inte;

import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PassiveOperationServiceInte {

    Mono<PassiveOperation> create(final PassiveOperation passiveOperation);

    Flux<PassiveOperation> readAll();

    Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation);

    Mono<PassiveOperation> updateById(final String id, final PassiveOperation passiveOperation);

    Mono<Void> deleteById(final String id);
}