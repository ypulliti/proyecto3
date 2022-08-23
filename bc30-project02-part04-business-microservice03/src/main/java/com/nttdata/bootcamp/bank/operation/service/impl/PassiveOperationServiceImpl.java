package com.nttdata.bootcamp.bank.operation.service.impl;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.PassiveOperationDaoInte;
import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.operation.service.inte.PassiveOperationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveOperationServiceImpl implements PassiveOperationServiceInte {

    private static final Logger log = LoggerFactory.getLogger(PassiveOperationServiceInte.class);

    @Autowired
    private PassiveOperationDaoInte passiveOpeartiontDaoInte;

    @Override
    public Mono<PassiveOperation> create(final PassiveOperation passiveOperation) {

        return passiveOpeartiontDaoInte.save(passiveOperation)
                .doFirst(() -> log.info("Begin create PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create PassiveOperation"));
    }

    @Override
    public Flux<PassiveOperation> readAll() {

        return passiveOpeartiontDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll PassiveOperation"));
    }

    @Override
    public Mono<PassiveOperation> readByCodePassiveOperation(String codePassiveOperation) {
        return passiveOpeartiontDaoInte.readByCodePassiveOperation(codePassiveOperation)
                .doFirst(() -> log.info("Begin findByCodeProduct PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct PassiveOperation"));
    }

    @Override
    public Mono<PassiveOperation> updateById(final String id, final PassiveOperation passiveOperation) {

        return passiveOpeartiontDaoInte.save(passiveOperation)
                .doFirst(() -> log.info("Begin updateById PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById PassiveOperation"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return passiveOpeartiontDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById PassiveOperation"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById PassiveOperation"));
    }

}