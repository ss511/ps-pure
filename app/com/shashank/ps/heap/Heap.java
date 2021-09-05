package com.shashank.ps.heap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Heap {
    private int data;
    private Heap left;
    private Heap right;

}
