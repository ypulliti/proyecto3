package com.nttdata.bootcamp.bank.operation;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.PassiveOperationDaoInte;
import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class SpringBootMicroserviceOperationApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceOperationApplication.class);

    @Autowired
    private PassiveOperationDaoInte dao;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceOperationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init PassiveOperation");
        // code to fix database and generate sample data
        Flux.just(
                new PassiveOperation("1","1", "credito empresarial", "credito", "1", new Date(), 0.0,0.0, 0.0, 0.0, "1","1", "1"),
                new PassiveOperation("1","2", "credito Personal", "credito", "2", new Date(), 100.0,0.0, 0.0, 0.0, "1","1", "1")

                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getName()));

    }

}
