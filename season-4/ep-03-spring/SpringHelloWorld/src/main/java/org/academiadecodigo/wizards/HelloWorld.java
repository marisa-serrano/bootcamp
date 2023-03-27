package org.academiadecodigo.wizards;

public class HelloWorld {
    private String name;

    public HelloWorld() {}

    public HelloWorld(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println("Hello world from " + name);
    }
}
