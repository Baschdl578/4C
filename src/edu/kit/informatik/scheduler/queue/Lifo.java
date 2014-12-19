package edu.kit.informatik.scheduler.queue;

import edu.kit.informatik.scheduler.job.Job;

import java.util.*;

/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class Lifo extends Stack<Job> implements edu.kit.informatik.scheduler.queue.Queue {
    public boolean add(Job job) {
        return push(job).equals(job);
    }

    public Job remove() {
        return pop();
    }

    public String toString() {
        Job current = this.peek();
        String out = "";
        if (current != null) {
            out += current.getName() + "(" + current.process() + ")";
            current = current.getNext();
        }
        while (current != null) {
            out += "," + current.getName() + "(" + current.process() + ")";

            current = current.getNext();
        }
        return out;
    }
}
