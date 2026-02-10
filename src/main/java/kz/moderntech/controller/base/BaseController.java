package kz.moderntech.controller.base;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<T, ID> {

    protected final JpaRepository<T, ID> repository;

    @PostMapping
    public ResponseEntity create(@RequestBody T entity) {
        repository.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<T> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable ID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
