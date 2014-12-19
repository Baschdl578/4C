package edu.kit.informatik.scheduler.queue;

import edu.kit.informatik.scheduler.job.Job;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class Sjf extends PriorityQueue<Job> implements edu.kit.informatik.scheduler.queue.Queue {
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

