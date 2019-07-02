package com.xiaoze17;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue;
    //private int numOfPing = 0;
    public RecentCounter() {
        queue = new ArrayDeque<>(3001);
    }

    public int ping(int t) {
        queue.offer(t);
        while(t-3000>queue.peek()) {
            queue.poll();
        }
        return queue.size();
    }
}
