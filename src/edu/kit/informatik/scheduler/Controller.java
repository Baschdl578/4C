package edu.kit.informatik.scheduler;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.scheduler.job.ComplexJob;
import edu.kit.informatik.scheduler.job.Job;
import edu.kit.informatik.scheduler.job.SimpleJob;
import edu.kit.informatik.scheduler.queue.Fifo;
import edu.kit.informatik.scheduler.queue.Lifo;
import edu.kit.informatik.scheduler.queue.Sjf;

import java.util.EmptyStackException;

/**
 * @author Sebastian Schindler
 * @version 1.0
 */
public class Controller {
    private int time;
    private edu.kit.informatik.scheduler.queue.Queue queue;

    /**
     * Constructs a new controller with the supplies queue type
     * @param type queue type
     */
    public Controller(String type) {
        time = 0;

        if (type.equals("waitingarea=fifo")) {
            queue = new Fifo();
            return;
        }
        if (type.equals("waitingarea=lifo")) {
            queue = new Lifo();
            return;
        }
        if (type.equals("waitingarea=sjf")) {
            queue = new Sjf();
            return;
        }
        Terminal.printLine("Error, please provide a valid queue type");
        System.exit(1);
    }

    /**
     * Puts the jobs from the file in the queue
     * @param jobs Array of job descriptions
     * @return Array of Jobs
     */
    public Job[] parseJobs(String[] jobs) {
        Job[] out = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            String[] details = jobs[i].split(",");
            int complexity = new Integer(details[3]);
            int arrival = new Integer(details[2]);

            Job job;
            if (details[1].equals("simple")) {
                job = new SimpleJob(complexity, arrival, details[0]);
            } else {
                job = new ComplexJob(complexity, arrival, details[0]);
            }

            out[i] = job;
        }
        return out;
    }


    /**
     * Simulates and prints the scheduler
     * @param jobs Array of Jobs
     */
    public void simulate(Job[] jobs) {
        boolean working = false;
        Job current = null;
        boolean cont = true;
        int remaining = 0;


        do {
            for (Job i: jobs) {
                if (time == i.getArrivalTime()) {
                    queue.add(i.copy());
                    i.setComplexity(0);
                }
            }

            String out = "";
            out += time + ":";

            if (!working) {
                if (time < queue.peek().getArrivalTime()) {
                    out += "noneArrived";
                } else {
                    current = queue.remove();
                    remaining = current.process();
                    working = true;
                    out += current.getName() + "(" + remaining + ")";
                }
            } else {
                remaining--;
                if (remaining == 0) {
                    if (time < queue.peek().getArrivalTime()) {
                        working = false;
                        out += "noneArrived";
                    } else {
                        current = queue.remove();
                        remaining = current.process();
                        working = true;
                        out += current.getName() + "(" + remaining + ")";
                    }
                } else {
                    out += current.getName() + "(" + remaining + ")";
                }
            }


            out += ",Waiting:";

            if (queue.toString().equals("")) {
                out += "empty";
            } else {
                out += queue.toString();
            }
            Terminal.printLine(out);

            time++;


            //Requirements for quitting
            if (remaining == 1) {
                try {
                    Job tmp = queue.peek();
                    cont = (tmp != null);
                    for (Job i: jobs) {
                        if (i.getComplexity() != 0) {
                            cont = true;
                        }
                    }
                } catch (EmptyStackException e) {
                    cont = false;
                    for (Job i: jobs) {
                        if (i.getComplexity() != 0) {
                            cont = true;
                        }
                    }
                }
            }
        } while (cont);
    }

    /**
     * Initializes a new controller and starts simulation
     * @param args Program arguments
     */
    public static void main(String args[]) {
        if (args.length != 2 || args.length != 1) {
            Terminal.printLine("Please provide a filename and queue type");
            System.exit(1);
        }
        if (args.length == 1) {
            String[] arguments = new String[2];
            arguments[0] = args[0];
            arguments[1] = "waitingarea=fifo";
            Controller.main(arguments);
        }
        Controller controller = new Controller(args[1]);
        Job[] jobs = controller.parseJobs(Reader.read(args[0]));

        controller.simulate(jobs);
    }
}


