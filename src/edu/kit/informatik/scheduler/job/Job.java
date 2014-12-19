package edu.kit.informatik.scheduler.job;

/**
 * @author Sebastian Schindler
 * @version 1.0
 */
public interface Job {
    /**
     * Reurns the total runtime
     * @return runtime
     */
    int process();

    /**
     * Gets the arrival time of the Job
     * @return {@code this.arrivalTime}
     */
    int getArrivalTime();

    /**
     * Return the Job's complexity
     * @return {@code this.complexity}
     */
    int getComplexity();

    /**
     * Gets the name of the Job
     * @return {@code this.name}
     */
    String getName();

    /**
     * Returns the next Job
     * @return next Job
     */
    Job getNext();

    /**
     * Sets the pointer to the next Job in the list
     * @param next Next Job
     */
    void setNext(Job next);
}
