package com.woody_side.load_balancer.source_address_hash;

import com.woody_side.load_balancer.util.StabIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SourceAddressHash {

    private static final String REMOTE_IP_ADDRESS = "127.0.0.1";

    public static String getServer() {
        Set<String> servers = StabIpAddresses.getIpAddresses().keySet();
        List<String> ips = new ArrayList<>(servers);

        int remoteIpHash = REMOTE_IP_ADDRESS.hashCode() % ips.size();

        return ips.get(remoteIpHash);
    }
}
