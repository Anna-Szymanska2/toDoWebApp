package com.example.todowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "in28","Learn AWS",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(++todoCount, "in28","Learn DevOps",
                LocalDate.now().plusYears(2), false ));
        todos.add(new Todo(++todoCount, "in28","Learn Full Stack Development",
                LocalDate.now().plusYears(3), false ));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
        List<Todo> list = todos.stream().filter(predicate).toList();
        return list;
    }
    public void addNewTodo(String name, String description, LocalDate date, Boolean isDone){
        todos.add(new Todo(++todoCount, name, description, date, isDone));
    }
    public void deleteTodoByIt(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findTodoByIt(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo){
        deleteTodoByIt(todo.getId());
        todos.add(todo);
    }
}
