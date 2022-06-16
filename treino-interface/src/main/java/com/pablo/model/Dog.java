package com.pablo.model;

public class Dog implements Animal {

    private String nome = "Dog";

    @Override
    public String getNome() {
        return nome;
    }

}