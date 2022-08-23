package com.nttdata.bootcamp.bank.product.model.dao.inte;

import com.nttdata.bootcamp.bank.product.model.document.ProductSubTypeRule;
import com.nttdata.bootcamp.bank.product.model.document.Rule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductSubTypeRuleDaoInte extends ReactiveMongoRepository<ProductSubTypeRule, String> {
    Mono<ProductSubTypeRule> findById(String id);
}
