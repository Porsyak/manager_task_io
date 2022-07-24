package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (!tasks.contains(task)) tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
         return tasks.stream()
                 .sorted()
                 .collect(Collectors.toList())
                 .toString();

    }

}
