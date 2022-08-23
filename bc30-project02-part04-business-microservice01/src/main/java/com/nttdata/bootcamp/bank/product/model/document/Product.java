package com.nttdata.bootcamp.bank.product.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="product")
public class Product {

    @Id
    private String id;
    private String codeProduct;
    private String name;
    //private String description;
    //private String bankAccountNumber;
    //private String interbankAccountNumber;
    private String status;
    private String auditUserInsertName;
    private String auditUserInsertDate;
    private String auditUserInsertP;
    private String auditUserUpdateName;
    private String audituserUpdateDate;
    private String auditUserUpdateIp;
    private int idProductSubType;
    private int idCurrencyType;

}
