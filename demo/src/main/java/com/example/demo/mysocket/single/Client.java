package com.example.demo.mysocket.single;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;

public interface Client extends Closeable {
    void start(InetAddress ip, int port) throws IOException;
}
