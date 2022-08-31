package com.nttdata.bootcamp.bank.location.model.dao.inte;

import com.nttdata.bootcamp.bank.location.model.document.PassiveOperation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PassiveOperationDaoInte extends ReactiveMongoRepository<PassiveOperation, String> {
    Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation);
}
