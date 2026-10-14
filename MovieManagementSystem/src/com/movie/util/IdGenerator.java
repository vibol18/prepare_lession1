package com.movie.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private final AtomicInteger nextId;

    public IdGenerator() {
        this(1);
    }

    public IdGenerator(int firstId) {
        if (firstId <= 0) {
            throw new IllegalArgumentException("First ID must be positive.");
        }
        this.nextId = new AtomicInteger(firstId);
    }

    public int nextId() {
        return nextId.getAndIncrement();
    }
}
