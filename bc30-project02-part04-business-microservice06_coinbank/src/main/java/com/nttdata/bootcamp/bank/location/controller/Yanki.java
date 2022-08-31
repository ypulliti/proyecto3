package com.nttdata.bootcamp.bank.location.controller;

import com.nttdata.bootcamp.bank.location.kafkaConfig.KafkaStringConfig;
import com.nttdata.bootcamp.bank.location.model.document.CoinBank;
import com.nttdata.bootcamp.bank.location.model.document.YankiCustomer;
import com.nttdata.bootcamp.bank.location.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.location.service.inte.CoinBankServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/yanki")
public class Yanki
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
    private CoinBankServiceInte coinbankServiceInte;

    @Autowired
    Yanki(KafkaStringConfig kafkaStringConfig, WebClient.Builder webClientBuilder)
    {
        this.kafkaStringConfig = kafkaStringConfig;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8088").build();
        this.webClientCustomer = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Yanki(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8088").build();
        this.webClientCustomer = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    private static final Logger log = LoggerFactory.getLogger(Yanki.class);

    @GetMapping("getCoinBanks")
    public Flux<CoinBank> readAll() {
        log.debug("Begin RestController readAll Location");
        return coinbankServiceInte.readAll();
    }

    @GetMapping("getCoinBank/{customerID}")
    public Flux<CoinBank> getCoinBank(@PathVariable("customerID") String customerID)
    {
        WebClient http = WebClient.create();
        log.debug("Begin report test");

        Mono<YankiCustomer> monoCustomer = this.webClientCustomer.get().uri(uriBuilder -> uriBuilder
                .path("/api/customers/readByCodeCustomer/{codeCustomer}")
                .build(customerID)).retrieve().bodyToMono(YankiCustomer.class);

        final YankiCustomer yankiCustomer = new YankiCustomer();
        monoCustomer.subscribe(c ->
        {
            yankiCustomer.setId(c.getId());
            yankiCustomer.setCustomerImei(c.getCustomerImei());
            yankiCustomer.setCustomerNameSecond(c.getCustomerNameSecond());
            yankiCustomer.setCustomerNameSecond(c.getCustomerSurnameSecond());
            yankiCustomer.setCodeCustomer(c.getCodeCustomer());
        });

        Flux<PassiveOperation> fluxPassOperation = this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/api/passiveoperations/findByCustomerPassiveOperation/{codeCustomer}")
                .build(customerID)).retrieve().bodyToFlux(PassiveOperation.class);

        Flux<CoinBank> myflux = fluxPassOperation.map(c ->
        {
            CoinBank r = new CoinBank();
            r.setId("1");
            r.setCodeCustomer(yankiCustomer.getCodeCustomer());
            r.setStaffNameFirst(yankiCustomer.getCustomerImei());
            r.setStaffNameSecond(yankiCustomer.getCustomerNameSecond());
            r.setStaffSurnameSecond(yankiCustomer.getCustomerSurnameSecond());
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

    @PutMapping("update/{id}")
    public Mono<CoinBank> updateById(@RequestBody final CoinBank location, @PathVariable("id") final String id)
    {
        log.debug("Begin RestController updateById Location");
        return coinbankServiceInte.updateById(id, location);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id)
    {
        log.debug("Begin RestController deleteById Location");
        return coinbankServiceInte.deleteById(id);
    }

    @PostMapping("create")
    public Mono<CoinBank> create(@RequestBody final CoinBank coinbank) {
        log.debug("Begin RestController create COinBank");
        return coinbankServiceInte.create(coinbank);
    }

}
