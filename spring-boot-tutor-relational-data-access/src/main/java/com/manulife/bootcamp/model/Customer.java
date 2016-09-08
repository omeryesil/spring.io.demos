package com.awapi.springboot.bootcamp.model;


public class Customer {

    private long _id;
    private String _firstName, _lastName;

    public Customer (long id, String firstName, String lastName) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
    }

    @Override
    public String toString () {
        return String.format ("Customer[id=%d. firstName=%s, lastName=%s]",
                        _id, _firstName, _lastName);

    }



}
