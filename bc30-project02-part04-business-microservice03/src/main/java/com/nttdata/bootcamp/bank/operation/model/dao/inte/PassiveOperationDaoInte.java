package com.nttdata.bootcamp.bank.operation.model.dao.inte;

import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PassiveOperationDaoInte extends ReactiveMongoRepository<PassiveOperation, String> {
    Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation);
}
