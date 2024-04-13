package org.example;

import java.util.LinkedList;

public class ResultsCollector {
    private LinkedList<Long> list = new LinkedList<>();
    public synchronized void add(long result)
    {
        list.add(result);
    }

    public String toString()
    {
        //System.out.println("Prime numbers given in the input: " + list);
        return "Prime numbers given in the input: " + list;
    }
}
