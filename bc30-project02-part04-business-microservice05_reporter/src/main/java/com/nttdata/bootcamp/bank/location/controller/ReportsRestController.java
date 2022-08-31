package com.nttdata.bootcamp.bank.location.controller;

import com.netflix.discovery.converters.Auto;
import com.nttdata.bootcamp.bank.location.kafkaConfig.KafkaStringConfig;
import com.nttdata.bootcamp.bank.location.model.document.Customer;
import com.nttdata.bootcamp.bank.location.model.document.Location;
import com.nttdata.bootcamp.bank.location.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.location.model.document.Report;
import com.nttdata.bootcamp.bank.location.service.inte.LocationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reports")
public class ReportsRestController
{
    @RequestMapping("name")
    public String getMicroserviceName()
    {
        return "Hello";
    }

    private KafkaStringConfig kafkaStringConfig;

    private final WebClient webClient;
    private final WebClient webClientCustomer;

    @Autowired
    ReportsRestController(KafkaStringConfig kafkaStringConfig, WebClient.Builder webClientBuilder)
    {
        this.kafkaStringConfig = kafkaStringConfig;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8088").build();
        this.webClientCustomer = webClientBuilder.baseUrl("http://localhost:8080").build();
    }



    public ReportsRestController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8088").build();
        this.webClientCustomer = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    private static final Logger log = LoggerFactory.getLogger(ReportsRestController.class);

    @GetMapping("getLocations")
    public Flux<Location> readAll() {
        log.debug("Begin RestController readAll Location");

        Flux<Location> fluxLocation = this.webClient.get().uri("/api/locations", "L-0000000001").retrieve().bodyToFlux(Location.class);
        return fluxLocation;
    }

    @GetMapping("getCustomer/{customerID}")
    public Flux<Report> report(@PathVariable("customerID") String customerID)
    {
        WebClient http = WebClient.create();
        log.debug("Begin report test");
        //Flux<Location> fluxLocation = this.webClientCustomer.get().uri("/api/customers/readByCodeCustomer/{codeCustomer}", "L-0000000001").retrieve().bodyToFlux(Location.class);

        Mono<Customer> monoCustomer = this.webClientCustomer.get().uri( uriBuilder -> uriBuilder
                .path("/api/customers/readByCodeCustomer/{codeCustomer}")
                .build(customerID)).retrieve().bodyToMono(Customer.class);

        final Customer customer = new Customer();
        monoCustomer.subscribe(c ->
        {
            customer.setId(c.getId());
            customer.setStaffNameFirst(c.getStaffNameFirst());
            customer.setStaffNameSecond(c.getStaffNameSecond());
            customer.setStaffNameSecond(c.getStaffSurnameSecond());
            customer.setCodeType(c.getCodeType());
            customer.setCodeCustomer(c.getCodeCustomer());
        });

        Flux<PassiveOperation> fluxPassOperation = this.webClient.get().uri( uriBuilder -> uriBuilder
                .path("/api/passiveoperations/findByCustomerPassiveOperation/{codeCustomer}")
                .build(customerID)).retrieve().bodyToFlux(PassiveOperation.class);

        Flux<Report> myflux = fluxPassOperation.map(c ->
        {
            Report r = new Report();
            r.setId("1");
            r.setCodeCustomer(customer.getCodeCustomer());
            r.setStaffNameFirst(customer.getStaffNameFirst());
            r.setStaffNameSecond(customer.getStaffNameSecond());
            r.setStaffSurnameSecond(customer.getStaffSurnameSecond());
            r.setCodeType(customer.getCodeType());
            r.setCodeCustomerType(customer.getCodeCustomerType());
            r.setBalanceCommission(c.getBalanceCommission());
            r.setBalanceCurrent(c.getBalanceCurrent());
            r.setCodePassiveOperation(c.getCodePassiveOperation());
            r.setBalanceMove(c.getBalanceMove());
            r.setBalanceNew(c.getBalanceNew());
            r.setDescription(c.getDescription());
            r.setState(c.getState());
            r.setOperationDate(c.getOperationDate());
            return r;
        });

        return myflux;
    }

}