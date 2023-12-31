package com.woody_side.load_balancer.random;

import com.woody_side.load_balancer.LoadBalancer;
import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomLoad extends LoadBalancer {

    @Override
    public String getServer() {
        Set<String> servers = StabIpAddresses.getIpAddresses().keySet();

        List<String> ips = new ArrayList<>(servers);

        int randomIp = new Random().nextInt(ips.size());

        return ips.get(randomIp);
    }
}
