package com.nttdata.bootcamp.bank.location.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="yankicustomer")
public class YankiCustomer
{

    @Id
    private String id;
    private String codeCustomer; // dni, passport, etc
    private String customerImei;
    private String customerNameSecond;
    private String customerSurnameSecond;
    private String customerAddress;
    private String customerTelephone;
    private String state;
}

