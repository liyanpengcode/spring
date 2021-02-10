package com.spring.design.patterns.composite;

//import io.micrometer.core.instrument.MeterRegistry;

public interface CompositeMetrics {


    void add(Metrics registry);

    void remove(Metrics registry);

    void print();


}
