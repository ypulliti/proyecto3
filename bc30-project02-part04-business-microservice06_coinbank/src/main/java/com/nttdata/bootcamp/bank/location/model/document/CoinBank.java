package com.nttdata.bootcamp.bank.location.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="customer")
public class CoinBank
{
    @Id
    private String id;
    private String codeCustomer;  // code 6 is for coinbank
    private String staffNameFirst;
    private String staffNameSecond;
    private String staffSurnameSecond;
    private String codePassiveOperation;
    private String name;
    private String description;
    private Date operationDate;
    private Double balanceCurrent;
    private Double balanceMove;
    private Double balanceCommission;
    private Double balanceNew;
    private String state;
}
