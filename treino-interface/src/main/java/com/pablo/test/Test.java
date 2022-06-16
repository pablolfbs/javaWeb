package com.pablo.test;

import com.pablo.model.Animal;
import com.pablo.model.Dog;

public class Test {

    public static void main(String[] args) {
        
        Animal a = new Dog();
        System.out.println(a.getNome());

    }
}
