package com.nttdata.bootcamp.bank.location.controller;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.nttdata.bootcamp.bank.location.model.document.Location;
import com.nttdata.bootcamp.bank.location.service.impl.LocationServiceImpl;
import com.nttdata.bootcamp.bank.location.service.inte.LocationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/locations")
public class LocationRestController
{

    private static final Logger log = LoggerFactory.getLogger(LocationServiceInte.class);

    @Autowired
    private ApplicationInfoManager applicationInfoManager;
    @Autowired
    private LocationServiceInte productServiceInte;

    @PostMapping("create")
    public Mono<Location> create(@RequestBody final Location location) {
        log.debug("Begin RestController create Location");
        return productServiceInte.create(location);
    }

    @GetMapping
    public Flux<Location> readAll() {
        InstanceInfo applicationInfo = applicationInfoManager.getInfo();
        log.debug("Begin RestController readAll Location");
        return productServiceInte.readAll();
    }

    @GetMapping("/readByCodeLocation/{codeProduct}")
    public Mono<Location> readByCodeLocation(@PathVariable String codeLocation) {
        log.debug("Begin RestController findByCodeProduct Location");
        return productServiceInte.readByCodeLocation(codeLocation);
    }

    @PutMapping("update/{id}")
    public Mono<Location> updateById(@RequestBody final Location location, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Location");
        return productServiceInte.updateById(id, location);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Location");
        return productServiceInte.deleteById(id);
    }

}