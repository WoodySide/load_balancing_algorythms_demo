package com.woody_side.load_balancer.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class StabIpAddresses {

    public static Map<String, Integer> getIpAddresses() {
        return Map.of(
                "192.168.1.100", 1,
                "192.168.1.101", 1,
                "192.168.1.102", 4,
                "192.168.1.103", 1,
                "192.168.1.104", 1,
                "192.168.1.105", 3,
                "192.168.1.106", 1,
                "192.168.1.107", 2,
                "192.168.1.108", 1,
                "192.168.1.109", 1);
    }
}
