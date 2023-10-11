package com.woody_side.load_balancer.least_connections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current processing address is: " + new LeastConnections().getServer());
    }
}
