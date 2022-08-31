package com.nttdata.bootcamp.bank.operation.BussinesLogic;

import com.nttdata.bootcamp.bank.operation.model.dao.inte.BankAccountDao;
import com.nttdata.bootcamp.bank.operation.model.document.BankAccount;
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
public class AccountLogic
{
    @Autowired
    private BankAccountDao daoC;

    private static final Logger log = LoggerFactory.getLogger(AccountLogic.class);

    public Mono<BankAccount> getAccount(final String id)
    {
        return daoC.findById(id);
    }

    public void deleteAccount(final String id){
        daoC.deleteById(id).subscribe();
    }

    public String saveAccount(BankAccount person, MongoTemplate mongoTemplate)
    {
        String respuesta = InsertAccont(person, mongoTemplate);

        if (respuesta == messageOk)
            daoC.save(person).subscribe();

        if (respuesta.isEmpty())
            return "Sucess";
        else
            return respuesta;
    }

    public final String messageOk = "";

    public String InsertAccont(BankAccount bAccount, MongoTemplate mongoTemplate)
    {
        String result = messageOk;

        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(bAccount.getClientId()));
        List<BankAccount> queryResult = mongoTemplate.find(query, BankAccount.class);

        if (bAccount.getTypeClient().equals("personal"))
        {
            switch (bAccount.getPorductID())
            {
                case "cuenta corriente":
                case "ahorro":
                case "plazo fijo":

                    if(queryResult.size() > 0)
                        result = "el cliente ya tiene una cuenta bancaria";

                    break;

                case "credito personal":
                    long querySize = queryResult.stream().filter(c -> c.getPorductID() != "credito personal").count();

                    if (querySize > 0)
                        result = "el cliente ya tiene una cuenta bancaria";

                    break;

                default:
                    result = "Tipo de cuenta no valido";
            }
        }
        else
        {
            switch (bAccount.getPorductID())
            {
                case "cuenta corriente":
                    // el cliente puede tener una o varias cuentas de este tipo
                    break;

                case "cuenta empresarial":

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
