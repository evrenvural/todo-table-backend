package com.evrenvural.todo.resource;

import com.evrenvural.todo.dto.TodoDTO;
import com.evrenvural.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public Iterable<TodoDTO> getAllTodos(){
        return todoService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public TodoDTO addTodo(@RequestBody TodoDTO todoDTO){
        return todoService.addTodo(todoDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}/delete")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/update")
    public TodoDTO updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO){
        return todoService.updateTodo(id, todoDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/changeStatusNext")
    public TodoDTO changeStatusNext(@PathVariable Long id){
        return todoService.changeStatusNext(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/changeStatusPrev")
    public TodoDTO changeStatusPrev(@PathVariable Long id){
        return todoService.changeStatusPrev(id);
    }
}
