package com.nttdata.bootcamp.bank.location.model.dao.inte;

import com.nttdata.bootcamp.bank.location.model.document.YankiCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface YankiCustomerDaoInte extends ReactiveMongoRepository<YankiCustomer, String> {

    Mono<YankiCustomer> readByCodeCustomer(String codeCustomer);
}
