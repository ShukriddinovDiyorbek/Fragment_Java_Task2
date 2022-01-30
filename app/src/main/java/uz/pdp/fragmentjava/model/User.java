package uz.pdp.fragmentjava.model;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
}
