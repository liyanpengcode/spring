package com.spring.design.patterns.composite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompositeMetricsTests {


    @Test
    void contextLoads() {
        Metrics metrics= new Metrics("M","desc");

    Metrics work= new Work("M","desc");
    Metrics storyA= new Story("S","desc");
    Metrics storyB= new Story("S","desc");
        metrics.add(work);

        work.add(storyA);
        work.add(storyB);
        metrics.print();

    }

}
