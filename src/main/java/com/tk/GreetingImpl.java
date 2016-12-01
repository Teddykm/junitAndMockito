package com.tk;

public class GreetingImpl implements Greeting {

    public String greet(String name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return "Hello " + name;
    }

}
