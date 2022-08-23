package com.nttdata.bootcamp.bank.customer;

import com.nttdata.bootcamp.bank.customer.document.Customer;
import com.nttdata.bootcamp.bank.customer.inte.CustomerDaoInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceCustomerApplication implements CommandLineRunner {

    @Autowired
    private CustomerDaoInte dao;
    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceCustomerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceCustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init Customer");
        Flux.just(
                    new Customer("1","0001", "Test01", "Prueba 1", "None", new Date(), "9999", "0.9", "", "", "", "","898", "88", "00", "Lima", "1", "1"),
                    new Customer("2","0002", "Test02", "Prueba 2", "None", new Date(), "88888", "9090", "", "", "", "","898", "88", "00", "Lima", "1", "1")
                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getId()));

    }

}
