package com.example.demo.mysocket.single;

import java.io.Closeable;
import java.io.IOException;

public interface Server extends Closeable {
    void start(int port) throws IOException;
}
