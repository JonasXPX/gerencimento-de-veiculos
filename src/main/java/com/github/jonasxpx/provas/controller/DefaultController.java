package com.github.jonasxpx.provas.controller;

import com.github.jonasxpx.provas.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public class DefaultController<M, S extends DefaultService<M, ?>>{

    @Autowired
    private S service;

    @GetMapping
    public ResponseEntity<List<M>> findAll(){
        return ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<M> findById(@PathVariable Long id) {
        return ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<M> save(@RequestBody M entity) {
        String[] value = getClass().getAnnotation(RequestMapping.class)
                .value();
        System.out.println(Arrays.toString(value));

        return ResponseEntity.created(URI.create("/"))
                .body(service.persist(entity));
    }

    @PutMapping
    public ResponseEntity<M> update(@RequestBody M entity) {
        return ResponseEntity.ok(service.persist(entity));
    }

    public S getService() {
        return service;
    }
}
