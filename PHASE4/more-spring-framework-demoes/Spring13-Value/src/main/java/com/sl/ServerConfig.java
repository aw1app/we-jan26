package com.sl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {
    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    @Value("Production")
    private String env;

    @Value("${server.timeout:5000}")
    private int timeout;

    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getEnv() { return env; }
    public int getTimeout() { return timeout; }
}