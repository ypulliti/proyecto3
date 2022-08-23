package com.nttdata.bootcamp.bank.location.model.dao.inte;

import com.nttdata.bootcamp.bank.location.model.document.Location;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LocationDaoInte extends ReactiveMongoRepository<Location, String> {
    Mono<Location> readByCodeLocation(String codeProduct);
}
