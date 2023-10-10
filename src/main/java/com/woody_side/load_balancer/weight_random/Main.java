package com.woody_side.load_balancer.weight_random;

import com.woody_side.load_balancer.random.RandomLoad;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current processing address is: " + new WeightRandom().getServer());
    }
}
