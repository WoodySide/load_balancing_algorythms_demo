package com.woody_side.load_balancer.weight_round_robin;

import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WeightRoundRobin {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static String getServer() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(StabIpAddresses.getIpAddresses().entrySet());

        List<String> ips = entries.stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();

        return ips.get(counter.getAndAccumulate(ips.size(),
                (curr, n) -> curr >= n - 1? 0: curr + 1));
    }
}
