package com.nttdata.bootcamp.bank.product.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="currency_type")
public class CurrencyType
{

    @Id
    private String id;
    private String description;
    private String name;
    private String idProductType;

}
