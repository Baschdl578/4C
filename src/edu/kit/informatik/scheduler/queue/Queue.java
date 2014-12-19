package edu.kit.informatik.scheduler.queue;

import edu.kit.informatik.scheduler.job.Job;

/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public interface Queue {
    /**
     * Removes and returns the next Job
     * @return The next Job
     */
    Job remove();

    /**
     * Adds a Job to the queue
     * @param job Job to add
     * @return true if success
     */
    boolean add(Job job);

    /**
     * Returns the first Job without removing it
     * @return first Job
     */
    Job peek();

    /**
     * Returns a String with all elements
     * @return String with all elements
     */
    String toString();


}
