package com.nttdata.bootcamp.bank.operation.BussinesLogic;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.MovementDao;
import com.nttdata.bootcamp.bank.operation.model.document.BankAccount;
import com.nttdata.bootcamp.bank.operation.model.document.Movement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class MovementLogic
{
    public final String messageOk = "";

    @Autowired
    private MovementDao daoC;

    private static final Logger log = LoggerFactory.getLogger(MovementLogic.class);

    public Mono<Movement> getMovement(final String id){
        return this.daoC.findById(id);
    }

    public String saveMovement(Movement movement, MongoTemplate mongoTemplate)
    {
        String respuesta = InsertMovement(movement, mongoTemplate);

        if (respuesta == messageOk)
            daoC.save(movement).subscribe();

        if (respuesta.isEmpty())
            return "Sucess";
        else
            return respuesta;
    }
    public void deleteMovement(final String id){
        daoC.deleteById(id).subscribe();
    }

    public List<Movement> getMovementsPerClient(Movement movement, MongoTemplate mongoTemplate)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(movement.getClientId()));
        return mongoTemplate.find(query, Movement.class);
    }

    public List<Movement> getMovementsPerClientPerAccount(Movement movement, MongoTemplate mongoTemplate)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(movement.getClientId()).and("accountNumber").is(movement.getAccountNumber()));
        return mongoTemplate.find(query, Movement.class);
    }

    public String InsertMovement(Movement movement, MongoTemplate mongoTemplate)
    {
        String result = messageOk;
        List<Movement> movementsPerClient = getMovementsPerClient(movement, mongoTemplate);
        List<Movement> movementsPerClientPerAccount = getMovementsPerClientPerAccount(movement, mongoTemplate);
        long moves = movementsPerClientPerAccount.size();

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("clientId").is(movement.getAccountNumber()));
        List<BankAccount> queryResult2 = mongoTemplate.find(query2, BankAccount.class);

        if(queryResult2.size() == 0)
            return "no se encontraron resultados";

        BankAccount bCount = queryResult2.get(0);

        if (movement.getClientType().equals("personal"))
        {
            if(movement.getMovementType() == "retiro" && bCount.getCurrentAmount() < bCount.getCurrentAmount() - movement.getMovementAmount())
                return "No hay saldo suficiente en la cuenta";

            switch (movement.getAccountType())
            {
                case "ahorro":
                    // por ahora el límite es 30 movimvientos para todas las cuentas de ahorro
                    if(moves >= 30)
                        return "no se permiten mas movimientos";

                    break;

                case "cuenta corriente":
                    // no hay límite de movimvientos
                    break;

                case "plazo fijo":
                    // sólo permite un movimviento, por ahora voy a ignorar la condiciónd e un día específico
                    if(moves > 1)
                        return "el cliente ya realizo un movimiento";

                    break;

                case "credito personal":
                    if(movement.getMovementType() == "retiro" && bCount.getCurrentAmount() < bCount.getCurrentAmount() - movement.getMovementAmount())
                        return "No hay saldo suficiente en la cuenta";

                    long querySize = movementsPerClient.stream().filter(c -> c.getAccountType() != "credito personal").count();

                    if (querySize > 0)
                        result = "el cliente ya tiene una cuenta bancaria";

                    break;

                default:
                    result = "Tipo de cuenta no valido";
            }
        }
        else
        {
            switch (movement.getAccountType())
            {
                case "cuenta corriente":
                    // el cliente puede tener una o varias cuentas de este tipo, no hay límite de movimientos
                    break;

                case "cuenta empresarial":
                    if(movement.getMovementType() == "retiro" && bCount.getCurrentAmount() < bCount.getCurrentAmount() - movement.getMovementAmount())
                        return "No hay saldo suficiente en la cuenta";

                    break;

                case "credito personal":
                case "ahorro":
                case "plazo fijo":
                    result = "El cliente no puede tener este tipo de cuenta";
                    break;

                default:
                    result = "Tipo de cuenta no valido";
            }
        }


        return result;
    }

}
