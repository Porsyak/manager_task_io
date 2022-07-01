package ru.netology.javacore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {
    List<String> list = new ArrayList<>();
    @ParameterizedTest
    @ValueSource(strings = {"Апельсин", "Яблоко", "Мандарин", "Апельсин"})
    void addTask(String str) {
        if (!list.contains(str)) list.add(str);
    }

   @ParameterizedTest
   @ValueSource(strings = {"Аблоко", "Null"})
    void removeTask(String str) {
        list.remove(str);
    }

    @Test
    void getAllTasks() {
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
