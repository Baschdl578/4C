package edu.kit.informatik.scheduler.queue;
import edu.kit.informatik.scheduler.job.Job;

import java.util.LinkedList;

/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class Fifo extends LinkedList<Job> implements edu.kit.informatik.scheduler.queue.Queue {
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
