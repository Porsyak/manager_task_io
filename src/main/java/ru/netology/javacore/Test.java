package ru.netology.javacore;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Todos todos = new Todos();
        todos.addTask("1");
        todos.addTask("4");
        todos.addTask("2");
        todos.addTask("1");
        System.out.println(todos.getAllTasks());


    }
}
