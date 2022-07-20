package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonToken;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Todos getTodos() {
        return todos;
    }

    public void setTodos(Todos todos) {
        this.todos = todos;
    }

    private  int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8089);) { // стартуем один раз
            while (true) { // в цикле (!) принимаем подключение
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String task = in.readLine();
                    JsonObject jsonObject = JsonParser.parseString(task).getAsJsonObject();
                    String typeTask = jsonObject.get("type")
                            .toString()
                            .replace("\"","");
                    String addTask = jsonObject.get("task")
                            .toString();
                    if (typeTask.equals("ADD")) todos.addTask(addTask);
                    out.println("Твои задачи: " + todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }

    }
}
