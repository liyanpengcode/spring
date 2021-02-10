package com.spring.design.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Story extends Metrics implements  CompositeMetrics {
    List<Metrics> metrics = new ArrayList<>();


    public Story(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(Metrics registry) {
        metrics.add(registry);
    }

    @Override
    public void remove(Metrics registry) {
        metrics.remove(registry);
    }

    @Override
    public void print() {
        for (Metrics metric : metrics) {
            metric.print();
        }
    }
}
