package com.example.javase.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTests {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.stream().map(s -> s.contains("a")).collect(Collectors.toList());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
