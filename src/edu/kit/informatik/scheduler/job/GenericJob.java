package edu.kit.informatik.scheduler.job;


/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class GenericJob {
    private Job next;
    private int complexity;
    private String name;
    private int arrivalTime;

    /**
     * Constructor for a new Job.
     * @param complexity complexity
     * @param arrivalTime arrival time
     * @param name job name
     */
    public GenericJob(int complexity, int arrivalTime, String name) {
        this.complexity = complexity;
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the next Job
     * @return next Job
     */
    public Job getNext() {
        return next;
    }

    /**
     * Sets the pointer to the next Job in the list
     * @param next Next Job
     */
    public void setNext(Job next) {
        this.next = next;
    }

    /**
     * Return the Job's complexity
     * @return {@code this.complexity}
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * Gets the name of the Job
     * @return {@code this.name}
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the arrival time of the Job
     * @return {@code this.arrivalTime}
     */
    public int getArrivalTime() {
        return arrivalTime;
    }
}