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
        // code to fix database and generate sample data
        /*Flux.just(
                new Product("2","credito empresarial", "credito", "1", "0", "0", "", "", "", "",1, 1)
                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getName()));*/
    }

}
