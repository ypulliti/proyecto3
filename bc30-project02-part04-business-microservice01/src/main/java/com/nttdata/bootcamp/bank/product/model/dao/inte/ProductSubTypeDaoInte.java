package com.nttdata.bootcamp.bank.product.model.dao.inte;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.model.document.Rule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductSubTypeDaoInte extends ReactiveMongoRepository<ProductSubType, String> {
    Mono<ProductSubType> findById(String id);
}
