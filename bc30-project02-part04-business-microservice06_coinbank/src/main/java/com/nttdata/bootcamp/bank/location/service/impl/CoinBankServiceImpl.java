package com.nttdata.bootcamp.bank.location.service.impl;

import com.nttdata.bootcamp.bank.location.model.dao.inte.CoinBankDaoInte;
import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import com.nttdata.bootcamp.bank.location.service.inte.CoinBankServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoinBankServiceImpl implements CoinBankServiceInte
{

    private static final Logger log = LoggerFactory.getLogger(CoinBankServiceImpl.class);

    @Autowired
    private CoinBankDaoInte CoinBankDaoInte;

    @Override
    public Mono<CoinBank> create(final CoinBank location) {

        return CoinBankDaoInte.save(location)
                .doFirst(() -> log.info("Begin create CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create CoinBank"));
    }

    @Override
    public Flux<CoinBank> readAll() {

        return CoinBankDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll CoinBank"));
    }

    @Override
    public Mono<CoinBank> readByCodeLocation(String codeLocation) {
        return CoinBankDaoInte.readByCustomer(codeLocation)
                .doFirst(() -> log.info("Begin findByCodelocation CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodelocation CoinBank"));
    }

    @Override
    public Mono<CoinBank> updateById(final String id, final CoinBank location) {

        return CoinBankDaoInte.save(location)
                .doFirst(() -> log.info("Begin updateById CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById CoinBank"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return CoinBankDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById CoinBank"));
    }

}