package com.nttdata.bootcamp.bank.product;

import com.nttdata.bootcamp.bank.product.model.dao.inte.ProductDaoInte;
import com.nttdata.bootcamp.bank.product.model.document.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceProductApplication implements CommandLineRunner {

    @Autowired
    private ProductDaoInte dao;
    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceProductApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init Product");

        //var productos = dao.findAll().count().block();
        //productos.subscribe(c -> log.info(String.valueOf(c)));

        //Insert products
        Flux.just(
                new Product("2","002", "credito empresarial", "1", "0", "0", "", "", "", "",1, 1),
                new Product("1","001", "credito personal", "1", "0", "0", "", "", "", "",1, 1),
                new Product("3","002", "ahorro", "1", "0", "0", "", "", "", "",1, 1),
                new Product("4","001", "cuenta corriente", "1", "0", "0", "", "", "", "",1, 1),
                new Product("5","002", "plazo fijo", "1", "0", "0", "", "", "", "",1, 1),
                new Product("6","001", "monedero", "1", "0", "0", "", "", "", "",1, 1)
                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getName()));
    }

}
