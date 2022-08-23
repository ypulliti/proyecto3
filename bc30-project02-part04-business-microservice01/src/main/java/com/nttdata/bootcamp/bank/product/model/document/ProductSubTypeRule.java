package com.nttdata.bootcamp.bank.product.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="product_subtype_rule")
public class ProductSubTypeRule
{
    @Id
    private String id;
    private String value;
    private String status;
    private String idProductType;
    private String idRule;
}
