package com.enjoywith.enjoywith.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public abstract class BaseAddable<T> implements Addable<T> {
    private JpaRepository<T,Integer> repository;

    public BaseAddable(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T entity) {
        this.repository.save(entity);
    }

    protected JpaRepository<T, Integer> getRepository() {
        return this.repository;
    }
}
