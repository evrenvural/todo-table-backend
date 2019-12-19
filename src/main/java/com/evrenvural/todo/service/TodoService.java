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

    public TodoDTO get(Long id){
        Todo todo = todoRepository.getOne(id);

        return  modelMapper.map(todo, TodoDTO.class);
    }

    public TodoDTO addTodo(TodoDTO todoDTO){

        // converting to todo
        Todo todo =  modelMapper.map(todoDTO, Todo.class);

        todo.setStatus("Todo");

        Todo todoFromRepo = todoRepository.save(todo);

        return modelMapper.map(todoFromRepo, TodoDTO.class);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO){
        Todo todoFromRepo = todoRepository.getOne(id);

        todoFromRepo.setTitle(todoDTO.getTitle());
        todoFromRepo.setDescription(todoDTO.getDescription());
        todoFromRepo.setImportantValue(todoDTO.getImportantValue());
        todoFromRepo.setDate(todoDTO.getDate());

        Todo updatedTodo = todoRepository.save(todoFromRepo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    public TodoDTO changeStatusNext(Long id){
        Todo todo = todoRepository.getOne(id);

        if (todo.getStatus().equals("Todo")){
            todo.setStatus("InProgress");
        }
        else if(todo.getStatus().equals("InProgress")){
            todo.setStatus(("Done"));
        }

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    public TodoDTO changeStatusPrev(Long id){
        Todo todo = todoRepository.getOne(id);

        if (todo.getStatus().equals("Done")){
            todo.setStatus("InProgress");
        }
        else if(todo.getStatus().equals("InProgress")){
            todo.setStatus(("Todo"));
        }

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }
}
