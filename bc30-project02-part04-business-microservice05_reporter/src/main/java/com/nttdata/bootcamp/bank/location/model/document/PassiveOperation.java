package com.nttdata.bootcamp.bank.location.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection="passive_operation")
public class PassiveOperation
{
    @Id
    private String id;
    private String idCustomer;
    private String codePassiveOperation;
    private String name;
    private String description;
    private Date operationDate;
    private Double balanceCurrent;
    private Double balanceMove;
    private Double balanceCommission;
    private Double balanceNew;
    private String state;
    private String idOperationType;
    private String idLocationType;

}
