package com.amuse.service.model;

import lombok.Data;
import pojo.GenericModel;

import java.util.UUID;

@Data
public class User extends GenericModel<String> {


    private String name;

    private String address;


    @Override
    protected String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}