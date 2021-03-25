package com.github.jonasxpx.provas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class DefaultService<M, R extends JpaRepository<M, Long>> {

    @Autowired
    private R repository;

    public M persist(M entity) {
        return repository.save(entity);
    }

    public M findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<M> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public R getRepository() {
        return repository;
    }
}
