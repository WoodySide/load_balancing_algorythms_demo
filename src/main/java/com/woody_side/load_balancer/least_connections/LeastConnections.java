package com.woody_side.load_balancer.least_connections;

import com.woody_side.load_balancer.LoadBalancer;
import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LeastConnections extends LoadBalancer {

    private static final AtomicInteger counter = new AtomicInteger(0);

    /**
     * Here the value in a map is a number of connections,
     * so choose the server with the lease number of connections first
     * then iterate to other servers according to their NOC
     * @return
     */
    @Override
    public String getServer() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(StabIpAddresses.getIpAddresses().entrySet());

        List<String> ips = entries.stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();

        return ips.get(counter.getAndAccumulate(ips.size(),
                (curr, n) -> curr >= n - 1? 0: curr + 1));
    }
}
