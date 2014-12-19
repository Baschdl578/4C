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
     */
    public void parseJobs(String[] jobs) {
        for(String i: jobs) {
            String[] details = i.split(",");
            int complexity = new Integer(details[3]);
            int arrival = new Integer(details[2]);

            Job job;
            if (details[1].equals("simple")) {
                job = new SimpleJob(complexity, arrival, details[0]);
            } else {
                job = new ComplexJob(complexity, arrival, details[0]);
            }

            queue.add(job);
        }
    }

    /**
     * Simulates and prints the
     */
    public void simulate() {
        boolean working = false;
        Job current = null;
        int startTime = 0;
        int times = 1;
        while (times > 0) {
            if (time == queue.peek().getArrivalTime()) {
                if (!working) {
                    working = true;
                    current = queue.remove();
                    startTime = time;
                } else {
                    if (current.process() + 1 + startTime == time) {
                        current = queue.remove();
                        startTime = time;
                    } else working = false;
                }
            }
            int remaining = 0;
            String out = "";
            out += time + ":";
            if (working) {
                out += current.getName() + "(";
                remaining = current.process() - (time - startTime);
                out += remaining + ")";
            } else out += "noneArrived";
            out += ",Waiting:";
            if (!queue.toString().equals("")) {
                out += queue.toString();
            } else out += "empty";

            Terminal.printLine(out);
            time++;

            Job stopper = null;
            try {
                stopper = queue.peek();
            } catch (EmptyStackException e) {
                times = remaining;
            }
            if (stopper == null) {
                times = remaining;
            }
        }
    }

    /**
     * Initializes a new controller and starts simulation
     * @param args
     */
    public static void main(String args[]) {
        if (args.length != 2) {
            Terminal.printLine("Please provide a filename and queue type");
            System.exit(1);
        }
        Controller controller = new Controller(args[1]);
        controller.parseJobs(Reader.read(args[0]));

        controller.simulate();
    }
}


