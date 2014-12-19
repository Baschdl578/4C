package edu.kit.informatik.scheduler.job;

/**
 * @author Sebastian Schindler
 * @version 1.0
 */
public interface Job {
    /**
     * Returns the total runtime
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
     * Sets the complexity
     * @param complexity new complexity
     */
    void setComplexity(int complexity);


    /**
     * copies a job
     * @return similar job
     */
    Job copy();
}
