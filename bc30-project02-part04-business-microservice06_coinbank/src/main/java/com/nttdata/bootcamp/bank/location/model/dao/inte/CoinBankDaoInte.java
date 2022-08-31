package com.nttdata.bootcamp.bank.location.model.dao.inte;

import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CoinBankDaoInte extends ReactiveMongoRepository<CoinBank, String>
{
    Mono<CoinBank> readById(String codeCoinBank);
    Mono<CoinBank> readByCode(String codeCoinBank);
    Mono<CoinBank> readByCustomer(String codeCoinBank);
}
