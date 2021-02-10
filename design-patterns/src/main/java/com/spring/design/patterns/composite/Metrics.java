package com.spring.design.patterns.composite;


import java.util.ArrayList;
import java.util.List;


public class Metrics implements CompositeMetrics{

    String name ;
    String description ;

    List<Metrics> metrics = new ArrayList<>();

    public Metrics(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Metrics() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void add(Metrics registry) {
        metrics.add(registry);
    }

    @Override
    public void remove(Metrics registry) {
        metrics.remove(this);
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", metrics=" + metrics.toArray().toString() +
                '}';
    }

    @Override
    public void print() {

        for (Metrics metric : metrics) {
            System.out.println(metric);
        }

    }
}
