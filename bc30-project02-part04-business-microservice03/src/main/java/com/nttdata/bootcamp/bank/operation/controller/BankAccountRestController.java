package com.nttdata.bootcamp.bank.operation.controller;

import com.nttdata.bootcamp.bank.operation.BussinesLogic.AccountLogic;
import com.nttdata.bootcamp.bank.operation.model.dao.inte.BankAccountDao;
import com.nttdata.bootcamp.bank.operation.model.document.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apis")
public class BankAccountRestController
{
	@Autowired
	private BankAccountDao dao;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	private final String messageOk = "";

	@Autowired
	private AccountLogic cControl = new AccountLogic();

	private static final Logger log = LoggerFactory.getLogger(BankAccountRestController.class);

	@GetMapping("showPersonalBankAccounts")
	public Flux<BankAccount> showPersonalBankAccounts(){

		Flux<BankAccount> productos = dao.findAll()
				.map(producto -> {
					producto.setName(producto.getName().toUpperCase());
					return producto;
				})
				.doOnNext(prod -> log.info(prod.getName()));

		return productos;
	}

	@GetMapping("showPersonalBankAccount/{id}")
	public Mono<BankAccount> showPersonalBankAccount(@PathVariable String id)
	{
		Flux<BankAccount> productos = dao.findAll();
		
		Mono<BankAccount> producto = productos
				.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getName()));
				
		return producto;
	}

	@GetMapping("showPersonalBankAccountByClient/{clientId}")
	public Mono<BankAccount> showPersonalBankAccountByClient(@PathVariable String clientId){
		Query query = new Query();
		query.addCriteria(Criteria.where("clientId").is(clientId));
		return reactiveMongoTemplate.find(query, BankAccount.class).next();
	}

	@PutMapping("insertPersonalAccount/{id}/{nombre}/{tipoCuentaBancaria}/{clienteId}/{typeClient}/{amount}")
	public String insertAccount(@PathVariable String id,
								@PathVariable String nombre,
								@PathVariable String tipoCuentaBancaria,
								@PathVariable String clienteId,
								@PathVariable String typeClient,
								@PathVariable double amount)
	{
		BankAccount bClient = new BankAccount(nombre, tipoCuentaBancaria, id, clienteId, typeClient, amount, amount);
		String respuesta = cControl.saveAccount(bClient, mongoTemplate);
		return respuesta;
	}

	@PutMapping("updatePersonalAcocunt/{id}/{nombre}/{tipoCuentaBancaria}/{clienteId}/{typeClient}/{currentAmount}/{finalAmount}")
	public String updateAcocunt(@PathVariable String id,
								@PathVariable String nombre,
								@PathVariable String tipoCuentaBancaria,
								@PathVariable String clienteId,
								@PathVariable String typeClient,
								@PathVariable double currentAmount,
								@PathVariable double finalAmount)
	{
		BankAccount bClient = new BankAccount(nombre, tipoCuentaBancaria, id, clienteId, typeClient, currentAmount, finalAmount);
		String respuesta = cControl.saveAccount(bClient, mongoTemplate);
		return respuesta;
	}

	@DeleteMapping("deletePersonalAccount/{id}")
	public String deleteAccount(@PathVariable String id)
	{
		cControl.deleteAccount(id);
		return "Sucess";
	}

}
