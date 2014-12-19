package edu.kit.informatik.scheduler.job;

/**
 * @version 1.0
 * @author Sebastian Schindler
 */
public class SimpleJob extends GenericJob implements Job, Comparable<Job> {

    /**
     * Constructor for a new Job.
     * @param complexity complexity
     * @param arrivalTime arrival time
     * @param name job name
     */
    public SimpleJob(int complexity, int arrivalTime, String name) {
        super(complexity, arrivalTime, name);
    }

    /**
     * Compares this job's runtime to that of another.
     * @param job Other job
     * @return negative {@code int} if this job's runtime is shorter
     *      than the other's,
     *      zero if they are the same and positive otherwise
     */
    public int compareTo(Job job) {
        return this.process() - job.process();
    }

    /**
     * Returns the total runtime of this Job.
     * @return Runtime
     */
    public int process() {
        return this.getComplexity();
    }
}
