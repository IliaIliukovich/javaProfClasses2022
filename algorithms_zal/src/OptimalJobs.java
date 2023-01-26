import java.util.*;

public class OptimalJobs {


    // Given n tasks, where each task has a deadline and cost.
    // It is also known that each task takes one unit of time, so the minimum possible deadline for any task is 1.
    // How to maximize the total profit if only one task can be scheduled at a time?

    static class Job {
        int cost;
        int deadline;

        public Job(int cost, int deadline) {
            this.cost = cost;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "Job{" + "cost=" + cost + ", deadline=" + deadline + '}';
        }
    }

    public static void main(String[] args) {

        Job job1 = new Job(70, 1);
        Job job2 = new Job(50, 1);
        Job job3 = new Job(170, 3);
        Job job4 = new Job(20, 3);
        Job job5 = new Job(40, 2);
        Job job6 = new Job(50, 2);
        Job job7 = new Job(80, 3);
        List<Job> jobs = Arrays.asList(job1, job2, job3, job4, job5, job6, job7);

        printJobsSequence(jobs);
    }

    private static void printJobsSequence(List<Job> jobs) {
        jobs.sort((o1, o2) -> o2.cost - o1.cost);
        int maxDays = jobs.stream().map(job -> job.deadline).max(Comparator.naturalOrder()).get();

        System.out.println("List of jobs sorted:");
        jobs.forEach(System.out::println);
        System.out.println("Maxdays: " + maxDays);

        boolean[] isJobPresent = new boolean[maxDays];
        List<Job> listOfJobsToDo = new ArrayList<>();

        for (Job job : jobs) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (!isJobPresent[i]) {
                    listOfJobsToDo.add(job);
                    isJobPresent[i] = true;
                    break;
                }
            }
        }

        System.out.println("Final timetable will be:");
        listOfJobsToDo.sort((o1, o2) -> o1.deadline - o2.deadline);
        listOfJobsToDo.forEach(System.out::println);
        System.out.println("The maximum amount of money I can get:");
        Integer totalSum = listOfJobsToDo.stream().map(job -> job.cost).reduce(Integer::sum).get();
        System.out.println(totalSum);

    }


}
