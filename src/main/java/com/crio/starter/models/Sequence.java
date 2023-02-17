package com.crio.starter.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sequence")
@Data
public class Sequence {

    @Id
    private String _id;

    @Field
    private String id;

    @Field
    private int seq;

    // constructors, getters, setters, etc.
    
}