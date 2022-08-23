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
public class Customer
{

    @Id
    private String id;
    private String codeCustomer;
    private String staffNameFirst;
    private String staffNameSecond;
    private String staffSurnameSecond;
    private Date staffBirthday;
    private String staffCellphone;
    private String staffGeoloc;
    private String staffAddress;
    private String businessTradeName;
    private String businessTaxName;
    private String businessTaxIdentificationNumber;
    private String businessTelephone;
    private String businessGeoloc;
    private String businessAddress;
    private String state;
    private String codeType;

    private String codeCustomerType;

}

