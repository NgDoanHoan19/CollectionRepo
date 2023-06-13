package com.example.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Collections.class,args);
    }


}
