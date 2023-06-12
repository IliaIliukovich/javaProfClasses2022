package lesson20230612;

import java.util.*;

public class OptimaJobTask {

    static class Task {
        Integer deadline;
        int cost;

        public Task(int deadline, int cost) {
            this.deadline = deadline;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Task{" + "deadline=" + deadline + ", cost=" + cost + '}';
        }
    }

    public static void printOptimalTaskList(List<Task> tasks) {
        List<Task> optimalTaskList = new ArrayList<>();
        tasks.sort((o1, o2) -> o2.cost - o1.cost);
        System.out.println(tasks);
        int lastDay = tasks.stream().map(task -> task.deadline).reduce(0, Math::max);
        System.out.println(lastDay);
        boolean[] isNotFree = new boolean[lastDay];
        for (Task t : tasks) {
            for (int i = t.deadline - 1; i >= 0 ; i--) {
                if (!isNotFree[i]) {
                    optimalTaskList.add(t);
                    isNotFree[i] = true;
                    break;
                }
            }
        }
        optimalTaskList.sort(Comparator.comparingInt(o -> o.deadline));
        System.out.println(optimalTaskList);
    }


    public static void main(String[] args) {
        Task task1 = new Task(4, 20);
        Task task2 = new Task(1, 10);
        Task task3 = new Task(1, 40);
        Task task4 = new Task(1, 30);
        Task task5 = new Task(3, 35);
        Task task6 = new Task(3, 30);
        printOptimalTaskList(Arrays.asList(task1, task2, task3, task4, task5, task6));
    }




}
