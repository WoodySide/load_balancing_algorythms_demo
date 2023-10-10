package com.woody_side.load_balancer.weight_random;

import com.woody_side.load_balancer.LoadBalancer;
import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.*;

public class WeightRandom extends LoadBalancer {

    @Override
    public String getServer() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(StabIpAddresses.getIpAddresses().entrySet());

        List<String> ips = entries.stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();

        int randomIp = new Random().nextInt(ips.size());

        return ips.get(randomIp);
    }
}
