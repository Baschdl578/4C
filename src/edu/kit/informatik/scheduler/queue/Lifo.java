package edu.kit.informatik.scheduler.queue;

import edu.kit.informatik.scheduler.job.Job;

import java.util.*;

/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class Lifo extends Stack<Job> implements edu.kit.informatik.scheduler.queue.Queue {
    /**
     * Adds a Job to the queue
     * @param job Job to add
     * @return true if success
     */
    public boolean add(Job job) {
        return push(job).equals(job);
    }

    /**
     * Removes and returns the next Job
     * @return The next Job
     */
    public Job remove() {
        return pop();
    }

    /**
     * Returns a String with all elements
     * @return String with all elements
     */
    public String toString() {
        Job current;
        String out = "";

        Iterator<Job> iter = this.iterator();

        if (iter.hasNext()) {
            current = iter.next();
            out += current.getName() + "(" + current.process() + ")";
        }

        while (iter.hasNext()) {
            current = iter.next();
            out += ",";
            out += current.getName() + "(" + current.process() + ")";
        }

        return out;
    }
}
