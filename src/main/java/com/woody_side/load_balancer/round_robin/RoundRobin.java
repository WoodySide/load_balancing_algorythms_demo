package com.woody_side.load_balancer.round_robin;

import com.woody_side.load_balancer.LoadBalancer;
import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin extends LoadBalancer {

    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public String getServer() {
        Set<String> servers = StabIpAddresses.getIpAddresses().keySet();
        List<String> ips = new ArrayList<>(servers);

        return ips.get(counter.getAndAccumulate(servers.size(),
                        (curr, n) -> curr >= n - 1? 0: curr + 1));
    }
}
