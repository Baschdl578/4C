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
     * @inheritDoc
     */
    public boolean add(Job job) {
        return push(job).equals(job);
    }

    /**
     * @inheritDoc
     */
    public Job remove() {
        return pop();
    }

    /**
     * @inheritDoc
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
