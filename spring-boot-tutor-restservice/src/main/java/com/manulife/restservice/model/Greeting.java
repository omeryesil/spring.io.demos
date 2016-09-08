package com.awapi.restservice.model;


public class Greeting {

    private final long _id;
    private final String _content;

    public Greeting (long id, String content) {
        _id = id;
        _content = content;
    }

    public long getId() {
        return _id;
    }

    public String getContent (){
        return _content;
    }

}
