package com.nttdata.bootcamp.bank.operation.model.dao.inte;

import com.nttdata.bootcamp.bank.operation.model.document.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovementDao extends ReactiveMongoRepository<Movement, String> {


}
