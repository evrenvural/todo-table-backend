package com.evrenvural.todo.resource;

import com.evrenvural.todo.domain.Todo;
import com.evrenvural.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/all")
    public Iterable<Todo> getAllTodos(){ return todoService.getAll(); }
}
