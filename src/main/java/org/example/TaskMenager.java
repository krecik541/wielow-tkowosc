package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TaskMenager {
    private final Queue<Long> queue = new LinkedList<>();

    public synchronized void add(long task)
    {
        queue.add(task);
        notify();
    }

    public synchronized long getTask() throws InterruptedException {
        while(queue.isEmpty())
        {
            wait();
        }
        return queue.remove();
    }
}
