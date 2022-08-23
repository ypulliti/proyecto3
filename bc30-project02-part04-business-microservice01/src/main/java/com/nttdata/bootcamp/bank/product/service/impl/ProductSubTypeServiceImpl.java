package com.nttdata.bootcamp.bank.product.service.impl;

import com.nttdata.bootcamp.bank.product.model.dao.inte.CurrencyTypeDaoInte;
import com.nttdata.bootcamp.bank.product.model.dao.inte.ProductSubTypeDaoInte;
import com.nttdata.bootcamp.bank.product.model.document.CurrencyType;
import com.nttdata.bootcamp.bank.product.model.document.ProductSubType;
import com.nttdata.bootcamp.bank.product.service.inte.CurrencyTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductSubTypeServiceInte;
import com.nttdata.bootcamp.bank.product.service.inte.ProductlServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductSubTypeServiceImpl implements ProductSubTypeServiceInte
{
    private static final Logger log = LoggerFactory.getLogger(ProductSubTypeServiceImpl.class);

    @Autowired
    private ProductSubTypeDaoInte productDaoInte;

    @Override
    public Mono<ProductSubType> create(final ProductSubType product) {

        return productDaoInte.save(product)
                .doFirst(() -> log.info("Begin create Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Product"));
    }

    @Override
    public Flux<ProductSubType> readAll() {

        return productDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Product"));
    }

    @Override
    public Mono<ProductSubType> findByCodeId(String codeProduct) {
        return productDaoInte.findById(codeProduct)
                .doFirst(() -> log.info("Begin findByCodeProduct Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeProduct Product"));
    }

    @Override
    public Mono<ProductSubType> updateById(final String id, final ProductSubType product) {

        return productDaoInte.save(product)
                .doFirst(() -> log.info("Begin updateById Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Product"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return productDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Product"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Product"));
    }

}