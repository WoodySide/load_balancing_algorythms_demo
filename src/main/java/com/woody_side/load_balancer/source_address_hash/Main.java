package com.woody_side.load_balancer.source_address_hash;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current processing address is: " + new SourceAddressHash().getServer());
    }
}
