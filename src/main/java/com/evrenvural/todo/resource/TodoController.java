package com.evrenvural.todo.resource;

import com.evrenvural.todo.domain.Todo;
import com.evrenvural.todo.dto.TodoDTO;
import com.evrenvural.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public Iterable<TodoDTO> getAllTodos(){ return todoService.getAll(); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public void addTodo(@RequestBody TodoDTO todoDTO){
        todoService.addTodo(todoDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}/delete")
    public void deleteTodo(@PathVariable Long id){ todoService.deleteTodo(id); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/update")
    public void updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO){ todoService.updateTodo(id, todoDTO); }
}
