package edu.kit.informatik.scheduler.job;


/**
 *
 * @author Sebastian Schindler
 * @version 1.0
 */
public class GenericJob {
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
     * @inheritDoc
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * @inheritDoc
     */
    public String getName() {
        return name;
    }

    /**
     * @inheritDoc
     */
    public int getArrivalTime() {
        return arrivalTime;
    }


    /**
     * @inheritDoc
     */
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

}
