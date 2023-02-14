package org.academiadecodigo.wizards;

public class Main {

    public static void main(String[] args) {

        ToDo todoList = new ToDo();

        todoList.add(ToDo.Importance.MEDIUM, 1, "Medium 2");
        todoList.add(ToDo.Importance.HIGH, 1, "High 1");
        todoList.add(ToDo.Importance.MEDIUM, 2, "Medium 3");
        todoList.add(ToDo.Importance.LOW, 1, "Low 1");
        todoList.add(ToDo.Importance.MEDIUM, 1, "Medium 1");


        while (!todoList.isEmpty()) {
            System.out.println(todoList.remove());
        }
    }
}
