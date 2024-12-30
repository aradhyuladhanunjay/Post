package com.post.Exception;

public class Resourcenotfound extends RuntimeException{

    private String message;

    public Resourcenotfound(String message) {
        super(message);
        this.message = message;
    }
}
