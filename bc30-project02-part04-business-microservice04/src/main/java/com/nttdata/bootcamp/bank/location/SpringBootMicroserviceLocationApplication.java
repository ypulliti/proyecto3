package com.nttdata.bootcamp.bank.location;

import com.nttdata.bootcamp.bank.location.model.dao.inte.LocationDaoInte;
import com.nttdata.bootcamp.bank.location.model.document.Location;
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
public class SpringBootMicroserviceLocationApplication implements CommandLineRunner {

    @Autowired
    LocationDaoInte dao;
    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceLocationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceLocationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init Location");
        // code to generate sample data, if database and collection does not exist, this code creates them
        Flux.just(
        new Location("1","PR-00009", "This", "1","0.0","111", "87887")
                )
                .flatMap(c -> dao.save(c))
                .subscribe(c -> log.info("Insert: " + c.getId() + " " + c.getName()));

    }

}
