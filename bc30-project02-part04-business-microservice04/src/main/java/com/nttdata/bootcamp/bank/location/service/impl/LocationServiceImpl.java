package com.nttdata.bootcamp.bank.location.service.impl;

import com.nttdata.bootcamp.bank.location.model.dao.inte.LocationDaoInte;
import com.nttdata.bootcamp.bank.location.model.document.Location;
import com.nttdata.bootcamp.bank.location.service.inte.LocationServiceInte;
import com.nttdata.bootcamp.bank.location.model.document.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationServiceImpl implements LocationServiceInte {

    private static final Logger log = LoggerFactory.getLogger(LocationServiceInte.class);

    @Autowired
    private LocationDaoInte locationDaoInte;

    @Override
    public Mono<Location> create(final Location location) {

        return locationDaoInte.save(location)
                .doFirst(() -> log.info("Begin create Location"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Location"));
    }

    @Override
    public Flux<Location> readAll() {

        return locationDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Location"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Location"));
    }

    @Override
    public Mono<Location> readByCodeLocation(String codeLocation) {
        return locationDaoInte.readByCodeLocation(codeLocation)
                .doFirst(() -> log.info("Begin findByCodelocation Location"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodelocation Location"));
    }

    @Override
    public Mono<Location> updateById(final String id, final Location location) {

        return locationDaoInte.save(location)
                .doFirst(() -> log.info("Begin updateById Location"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Location"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return locationDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Location"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Location"));
    }

}