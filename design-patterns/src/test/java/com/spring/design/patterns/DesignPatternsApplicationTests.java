package com.spring.design.patterns;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignPatternsApplicationTests {

    @Test
    void contextLoads() {
        Bug bug = new Bug("a", "desc");
    }

}

class Bug {
    private String name;
    private String desc;

    public Bug(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}