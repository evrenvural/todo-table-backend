package com.evrenvural.todo.service;

import com.evrenvural.todo.dao.TodoRepository;
import com.evrenvural.todo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll(){ return todoRepository.findAll(); }

}
