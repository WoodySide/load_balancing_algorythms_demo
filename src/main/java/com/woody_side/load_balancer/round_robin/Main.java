package com.woody_side.load_balancer.round_robin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current processing address is: " + RoundRobin.getServer());
    }
}
