package com.nttdata.bootcamp.bank.operation.model.dao.inte;

import com.nttdata.bootcamp.bank.operation.model.document.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BankAccountDao extends ReactiveMongoRepository<BankAccount, String>{

}
