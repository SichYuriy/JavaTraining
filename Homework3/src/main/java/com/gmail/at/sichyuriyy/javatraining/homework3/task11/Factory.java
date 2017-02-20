package com.gmail.at.sichyuriyy.javatraining.homework3.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.file.Files;
import java.util.Optional;

/**
 * Created by Yuriy on 20.02.2017.
 */
public class Factory {

    private ReferenceQueue<A> queue;
    private int maxObjectCount;
    private int objectCreatedCount = 0;
    private int objectFinalizedCount = 0;

    public Factory(int maxObjectCount) {
        this.maxObjectCount = maxObjectCount;
        queue = new ReferenceQueue<>();
    }

    public A createA() {
        if (objectCreatedCount - objectFinalizedCount >= maxObjectCount) {
            throw new IllegalStateException("can not create more than "
                    + maxObjectCount + " objects");
        }
        A result = new A();
        PhantomReference<A> phantomReference = new PhantomReference<>(result, queue);
        return result;
    }


    private void updateObjectFinalizedCount() {
        while (queue.poll() != null) {
            objectFinalizedCount++;
        }
    }

}
