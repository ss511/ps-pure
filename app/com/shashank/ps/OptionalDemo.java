package com.shashank.ps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Sample sample1 = new Sample(1, "abc");
        Sample sample2 = null;
        Optional<Sample> checkSample = Optional.ofNullable(sample2);
//        System.out.println(checkSample.orElseGet();
        checkSample.ifPresentOrElse(val -> {System.out.println(val.getNum());}, () -> {System.out.println("Missing");});
        System.out.println("Using orElseGet" + checkSample.orElseGet(() -> new Sample(2, "xyz")));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Sample {
    private int num;
    private String text;
}
