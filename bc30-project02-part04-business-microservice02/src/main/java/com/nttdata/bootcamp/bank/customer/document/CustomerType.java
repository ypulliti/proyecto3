package com.nttdata.bootcamp.bank.customer.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection="customer_type")
public class CustomerType
{
    @Id
    private String id;
    private String codeCustomerType;
    private String name;
    private String description;
    private String state;
}
