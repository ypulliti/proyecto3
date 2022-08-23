package com.nttdata.bootcamp.bank.location.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="location")
public class Location {

    @Id
    private String id;
    private String codeLocation;
    private String name;
    private String description;
    private String codeLocationType;
    private String codeUbigeo;
    private String codeEmployee;

}
