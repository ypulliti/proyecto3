package com.nttdata.bootcamp.bank.product.model.dao.inte;

import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.Rule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RuleDaoInte extends ReactiveMongoRepository<Rule, String> {
    Mono<Rule> findById(String id);
}
