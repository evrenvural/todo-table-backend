package com.evrenvural.todo.service;

import com.evrenvural.todo.dao.TodoRepository;
import com.evrenvural.todo.domain.Todo;
import com.evrenvural.todo.dto.TodoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TodoDTO> getAll() {

        List<Todo> todos = todoRepository.findAll();

        List<TodoDTO> todosDTO = new ArrayList<TodoDTO>();

        // converting
        for (Todo item: todos) {
            todosDTO.add(modelMapper.map(item, TodoDTO.class));
        }

        return todosDTO;
    }

    public void addTodo(TodoDTO todoDTO){

        // converting
        Todo todo =  modelMapper.map(todoDTO, Todo.class);

        todo.setStatus("Todo");

        todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public void updateTodo(Long id, TodoDTO todoDTO){
        Todo todoFromRepository = todoRepository.getOne(id);

        todoRepository.deleteById(id);

        // converting
        Todo updatedTodo = modelMapper.map(todoDTO, Todo.class);

        updatedTodo.setStatus(todoFromRepository.getStatus());

        todoRepository.save(updatedTodo);
    }

    public void changeStatusNext(Long id){
        Todo todo = todoRepository.getOne(id);

        if (todo.getStatus().equals("Todo")){
            todo.setStatus("InProgress");
        }
        else if(todo.getStatus().equals("InProgress")){
            todo.setStatus(("Done"));
        }

        todoRepository.save(todo);
    }

    public void changeStatusPrev(Long id){
        Todo todo = todoRepository.getOne(id);

        if (todo.getStatus().equals("Done")){
            todo.setStatus("InProgress");
        }
        else if(todo.getStatus().equals("InProgress")){
            todo.setStatus(("Todo"));
        }

        todoRepository.save(todo);
    }
}
